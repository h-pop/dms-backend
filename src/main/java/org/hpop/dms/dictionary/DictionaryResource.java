package org.hpop.dms.dictionary;

import jakarta.ws.rs.*;
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
  public Dictionary post(Dictionary dictionary) {
    return this.dictionaryService.create(dictionary);
  }

  @PUT
  public Dictionary put(Dictionary dictionary) {
    return this.dictionaryService.update(dictionary);
  }

  @DELETE
  @Path("{dictionaryId}")
  public Boolean delete(Integer dictionaryId) {
    return this.dictionaryService.delete(dictionaryId);
  }
}
