package org.hpop.dms.dictionary;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;
  private final DictionaryMapper dictionaryMapper;

  public DictionaryService(DictionaryRepository dictionaryRepository, DictionaryMapper dictionaryMapper) {
    this.dictionaryRepository = dictionaryRepository;
    this.dictionaryMapper = dictionaryMapper;
  }

  public Optional<Dictionary> findById(Integer dictionaryId) {
    return dictionaryRepository.findByIdOptional(dictionaryId).map(dictionaryMapper::toDomain);
  }

  public List<Dictionary> findAll() {
    return dictionaryRepository.findAll().stream().map(dictionaryMapper::toDomain).collect(Collectors.toList());
  }
}
