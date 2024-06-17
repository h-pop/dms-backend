package org.hpop.dms.dictionary.value;

public class DictionaryValue {

  private Integer id;

  private String value;

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
