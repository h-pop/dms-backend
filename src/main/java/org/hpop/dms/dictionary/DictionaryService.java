package org.hpop.dms.dictionary;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.hpop.dms.dictionary.value.DictionaryValueService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;
  private final DictionaryMapper dictionaryMapper;
  private final DictionaryValueService dictionaryValueService;

  public DictionaryService(DictionaryRepository dictionaryRepository, DictionaryMapper dictionaryMapper, DictionaryValueService dictionaryValueService) {
    this.dictionaryRepository = dictionaryRepository;
    this.dictionaryMapper = dictionaryMapper;
    this.dictionaryValueService = dictionaryValueService;
  }

  public Optional<Dictionary> findById(Integer dictionaryId) {
    return dictionaryRepository.findWithChildren(dictionaryId).map(dictionaryMapper::toDomainFull);
  }

  public List<Dictionary> findAll() {
    return dictionaryRepository.findAll().stream().map(dictionaryMapper::toDomain).collect(Collectors.toList());
  }

  @Transactional
  public Dictionary update(Dictionary dictionary) {
    if (dictionary.getId() == null) {
      throw new RuntimeException("Dictionary does not have id - cannot update!");
    }
    Optional<DictionaryEntity> optional = this.dictionaryRepository.findByIdOptional(dictionary.getId());
    if (optional.isEmpty()) {
      throw new RuntimeException(String.format("No Dictionary found for id[%s]", dictionary.getId()));
    }
    DictionaryEntity dictionaryEntity = optional.get();
    dictionaryEntity.setName(dictionary.getName());
    dictionaryRepository.persist(dictionaryEntity);
    return dictionaryMapper.toDomain(dictionaryEntity);
  }

  @Transactional
  public boolean delete(Integer dictionaryId) {
    return dictionaryRepository.deleteById(dictionaryId);
  }

  @Transactional
  public Dictionary create(Dictionary dictionary) {
    DictionaryEntity dictionaryEntity = dictionaryMapper.toEntity(dictionary);
    dictionaryRepository.persist(dictionaryEntity);
    var result = dictionaryMapper.toDomainFull(dictionaryEntity);
    result.setDictionaryValues(dictionaryValueService.createAll(dictionaryEntity.getId(), dictionary.getDictionaryValues()));
    return result;
  }
}
