package org.hpop.dms.dictionary.value;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DictionaryValueRepository implements PanacheRepositoryBase<DictionaryValueEntity, Integer> {

  public long deleteByDictionaryId(Integer dictionaryId) {
    return delete("DELETE FROM DictionaryValue dv WHERE dv.dictionaryId = ?1", dictionaryId);
  }

}
