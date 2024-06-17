package org.hpop.dms.dictionary.value;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DictionaryValueService {

  private final DictionaryValueMapper dictionaryValueMapper;

  private final DictionaryValueRepository dictionaryValueRepository;
  public DictionaryValueService(DictionaryValueMapper dictionaryValueMapper, DictionaryValueRepository dictionaryValueRepository) {
    this.dictionaryValueMapper = dictionaryValueMapper;
    this.dictionaryValueRepository = dictionaryValueRepository;
  }

//  public List<DictionaryValueEntity> updateAll(List<DictionaryValueEntity> dictionaryValues) {
//    return dictionaryValues.stream()
//      .map(this::update)
//      .collect(Collectors.toList());
//  }
//
//  private DictionaryValueEntity update(DictionaryValueEntity dictionaryValueEntity) {
//    if (dictionaryValueEntity.getId() == null) {
//      DictionaryValueEntity dictionaryValueEntity = dictionaryValueMapper.toEntity(dictionaryValueEntity);
//      dictionaryValueRepository.persist(dictionaryValueEntity);
//      return dictionaryValue;
//    }
//    return null;
//  }

  public List<DictionaryValue> createAll(final Integer dictionaryId, List<DictionaryValue> dictionaryValues) {
    return dictionaryValues.stream()
      .map(dictionaryValueMapper::toEntity)
      .peek(dve -> dve.setDictionaryId(dictionaryId))
      .peek(dictionaryValueRepository::persist)
      .map(dictionaryValueMapper::toDomain)
      .collect(Collectors.toList());
  }
}
