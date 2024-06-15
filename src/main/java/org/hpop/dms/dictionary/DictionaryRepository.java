package org.hpop.dms.dictionary;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class DictionaryRepository implements PanacheRepositoryBase<DictionaryEntity, Integer> {

  public Optional<DictionaryEntity> findWithChildren(Integer dictionaryId) {
    return find("SELECT d FROM Dictionary d LEFT JOIN FETCH d.dictionaryValues WHERE d.id = ?1", dictionaryId)
      .firstResultOptional();
  }
}
