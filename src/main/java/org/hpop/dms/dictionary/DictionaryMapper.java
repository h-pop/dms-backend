package org.hpop.dms.dictionary;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface DictionaryMapper {

  DictionaryEntity toEntity(Dictionary domain);
  Dictionary toDomain(DictionaryEntity entity);
}
