package org.hpop.dms.dictionary;

import jakarta.persistence.*;
import org.hpop.dms.dictionary.value.DictionaryValueEntity;

import java.util.List;

@Entity(name = "Dictionary")
@Table(name = "dictionary")
public class DictionaryEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name="dictionary_id")
  private List<DictionaryValueEntity> dictionaryValues;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<DictionaryValueEntity> getDictionaryValues() {
    return dictionaryValues;
  }

  public void setDictionaryValues(List<DictionaryValueEntity> dictionaryValues) {
    this.dictionaryValues = dictionaryValues;
  }
}
