package org.hpop.dms;

import io.quarkus.arc.impl.Sets;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/dictionary")
public class DictionaryResource {
  private final Set<Dictionary> dictionaries =
    Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

  public DictionaryResource() {
    dictionaries.add(
      new Dictionary("1", "Status",
        Sets.of(
          new DictionaryValue("1", "New"),
          new DictionaryValue("2", "Pending approval"),
          new DictionaryValue("3", "Approved"),
          new DictionaryValue("4", "Correction needed")
        )
      )
    );
    dictionaries.add(new Dictionary("2", "Office address",
        Sets.of(
          new DictionaryValue("5", "Wiejska 1/20, Warsaw"),
          new DictionaryValue("6", "St. Martin Street 2/12, Posen")
        )
      )
    );
    dictionaries.add(new Dictionary("5", "Departments",
        Sets.of(
          new DictionaryValue("15", "Human Resources"),
          new DictionaryValue("16", "Finance"),
          new DictionaryValue("17", "IT"),
          new DictionaryValue("18", "Sales"),
          new DictionaryValue("19", "Marketing")
        )
      )
    );
    dictionaries.add(new Dictionary("6", "Access Levels",
        Sets.of(
          new DictionaryValue("20", "Read-Only"),
          new DictionaryValue("21", "Read-Write"),
          new DictionaryValue("22", "Admin")
        )
      )
    );
    dictionaries.add(new Dictionary("7", "User Roles",
        Sets.of(
          new DictionaryValue("23", "Administrator"),
          new DictionaryValue("24", "Editor"),
          new DictionaryValue("25", "Viewer")
        )
      )
    );
    dictionaries.add(new Dictionary("8", "Storage Locations",
        Sets.of(
          new DictionaryValue("26", "Server Room"),
          new DictionaryValue("27", "Cloud Storage"),
          new DictionaryValue("28", "Off-site Backup")
        )
      )
    );
    dictionaries.add(new Dictionary("9", "Retention Policies",
        Sets.of(
          new DictionaryValue("29", "1 Year"),
          new DictionaryValue("30", "3 Years"),
          new DictionaryValue("31", "5 Years"),
          new DictionaryValue("32", "Permanent")
        )
      )
    );
    dictionaries.add(new Dictionary("10", "Document Formats",
        Sets.of(
          new DictionaryValue("33", "PDF"),
          new DictionaryValue("34", "Word Document"),
          new DictionaryValue("35", "Excel Spreadsheet"),
          new DictionaryValue("36", "Plain Text")
        )
      )
    );
    dictionaries.add(new Dictionary("11", "Priority Levels",
        Sets.of(
          new DictionaryValue("37", "High"),
          new DictionaryValue("38", "Medium"),
          new DictionaryValue("39", "Low")
        )
      )
    );
    dictionaries.add(new Dictionary("12", "Languages",
        Sets.of(
          new DictionaryValue("40", "English"),
          new DictionaryValue("41", "Polish"),
          new DictionaryValue("42", "German"),
          new DictionaryValue("43", "French")
        )
      )
    );
  }

  @GET
  public Set<Dictionary> getDictionaries() {
    return dictionaries;
  }

  @GET
  @Path("{dictionaryId}")
  public Dictionary getDictionary(String dictionaryId) {
    return dictionaries.stream().filter(d -> d.id().equals(dictionaryId)).findFirst().orElse(null);
  }

  @POST
  public void update(Dictionary dictionary) {
    this.delete(dictionary.id());
    this.dictionaries.add(dictionary);
  }

  @DELETE
  @Path("{dictionaryId}")
  public void delete(String dictionaryId) {
    this.dictionaries.removeIf(d -> d.id().equals(dictionaryId));
  }
}
