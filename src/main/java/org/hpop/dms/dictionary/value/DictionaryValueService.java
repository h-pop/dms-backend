package org.hpop.dms.dictionary.value;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class DictionaryValueService {

  private final DictionaryValueMapper dictionaryValueMapper;

  private final DictionaryValueRepository dictionaryValueRepository;
  public DictionaryValueService(DictionaryValueMapper dictionaryValueMapper, DictionaryValueRepository dictionaryValueRepository) {
    this.dictionaryValueMapper = dictionaryValueMapper;
    this.dictionaryValueRepository = dictionaryValueRepository;
  }

  public List<DictionaryValue> updateAll(Integer dictionaryId, List<DictionaryValue> dictionaryValues) {
    return dictionaryValues.stream()
      .map(dv -> update(dictionaryId, dv))
      .collect(Collectors.toList());
  }

  private DictionaryValue update(Integer dictionaryId, DictionaryValue dictionaryValue) {
    if (dictionaryValue.getId() == null) {
      return create(dictionaryId, dictionaryValue);
    }
    Optional<DictionaryValueEntity> optional = dictionaryValueRepository.findByIdOptional(dictionaryValue.getId());
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("No Dictionary value found for id[%s]", dictionaryValue.getId()));
    }
    DictionaryValueEntity entity = optional.get();
    entity.setValue(dictionaryValue.getValue());
    dictionaryValueRepository.persist(entity);
    return dictionaryValueMapper.toDomain(entity);
  }

  public List<DictionaryValue> createAll(Integer dictionaryId, List<DictionaryValue> dictionaryValues) {
    return dictionaryValues.stream()
      .map(dv -> create(dictionaryId, dv))
      .collect(Collectors.toList());
  }

  public DictionaryValue create(Integer dictionaryId, DictionaryValue dictionaryValue) {
    DictionaryValueEntity dictionaryValueEntity = dictionaryValueMapper.toEntity(dictionaryValue);
    dictionaryValueEntity.setDictionaryId(dictionaryId);
    dictionaryValueRepository.persist(dictionaryValueEntity);
    return dictionaryValueMapper.toDomain(dictionaryValueEntity);
  }

  public long deleteByDictionaryId(Integer dictionaryId) {
    return dictionaryValueRepository.deleteByDictionaryId(dictionaryId);
  }
}
