package org.hpop.dms.dictionary;

import org.hpop.dms.dictionary.value.DictionaryValueMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = DictionaryValueMapper.class)
public interface DictionaryMapper {

  DictionaryEntity toEntity(Dictionary domain);
  Dictionary toDomain(DictionaryEntity entity);
}
