package org.hpop.dms.dictionary.value;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DictionaryValueRepository implements PanacheRepositoryBase<DictionaryValueEntity, Integer> {

}
