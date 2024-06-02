package org.hpop.dms.dictionary;

import java.util.Set;

public record Dictionary(String id, String name, Set<DictionaryValue> dictionaryValues) { }