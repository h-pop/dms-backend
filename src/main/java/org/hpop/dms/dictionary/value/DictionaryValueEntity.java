package org.hpop.dms.dictionary.value;

import jakarta.persistence.*;

@Entity(name="DictionaryValue")
@Table(name="dictionary_value")
public class DictionaryValueEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "value")
  private String value;

  @Column(name = "dictionary_id")
  private Integer dictionaryId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getDictionaryId() {
    return dictionaryId;
  }

  public void setDictionaryId(Integer dictionaryId) {
    this.dictionaryId = dictionaryId;
  }
}
