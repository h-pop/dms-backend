package org.hpop.dms.dictionary;

import io.quarkus.arc.impl.Sets;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/dictionary")
public class DictionaryResource {

  private final DictionaryService dictionaryService;
  public DictionaryResource(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @GET
  public Response getDictionaries() {
    return Response.ok(dictionaryService.findAll()).build();
  }

  @GET
  @Path("{dictionaryId}")
  public Response getDictionary(Integer dictionaryId) {
    Optional<Dictionary> optional = dictionaryService.findById(dictionaryId);
    return optional.isPresent() ?
      Response.ok(optional.get()).build() :
      Response.status(Response.Status.NOT_FOUND).build();
  }

  @POST
  public void update(Dictionary dictionary) {
    // TODO HP handle update
//    this.delete(dictionary.getId());
//    this.dictionaries.add(dictionary);
  }

  @DELETE
  @Path("{dictionaryId}")
  public void delete(Integer dictionaryId) {
    // TODO HP handle delete
//    this.dictionaries.removeIf(d -> d.getId().equals(dictionaryId));
  }
}
