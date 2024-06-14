package org.hpop.dms.dictionary;

import org.hpop.dms.dictionary.value.DictionaryValue;

import java.util.List;

public class Dictionary {

  private Integer id;

  private String name;

  private List<DictionaryValue> dictionaryValues;

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

  public List<DictionaryValue> getDictionaryValues() {
    return dictionaryValues;
  }

  public void setDictionaryValues(List<DictionaryValue> dictionaryValues) {
    this.dictionaryValues = dictionaryValues;
  }
}