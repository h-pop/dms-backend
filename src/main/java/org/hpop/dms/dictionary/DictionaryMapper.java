package org.hpop.dms.dictionary;

import org.hpop.dms.dictionary.value.DictionaryValueMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", uses = DictionaryValueMapper.class)
public interface DictionaryMapper {

  DictionaryEntity toEntity(Dictionary domain);

  @Mapping(target="dictionaryValues", ignore = true)
  Dictionary toDomain(DictionaryEntity entity);

  Dictionary toDomainFull(DictionaryEntity entity);
}
