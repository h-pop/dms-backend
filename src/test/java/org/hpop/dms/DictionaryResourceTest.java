package org.hpop.dms;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class DictionaryResourceTest {
    @Test
    void testGetDictionaries() {
        given()
          .when().get("/dictionary")
          .then()
             .statusCode(200);
    }
    @Test
    void testGetDictionary() {
        given()
                .when().get("/dictionary/1")
                .then()
                .statusCode(200);
    }
}