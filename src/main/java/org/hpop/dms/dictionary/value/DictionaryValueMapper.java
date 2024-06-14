package org.hpop.dms.dictionary.value;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface DictionaryValueMapper {

  DictionaryValueEntity toEntity(DictionaryValue domain);
  DictionaryValue toDomain(DictionaryValueEntity entity);
}
