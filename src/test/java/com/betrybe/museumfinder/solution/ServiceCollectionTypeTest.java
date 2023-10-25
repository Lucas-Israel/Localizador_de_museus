package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testes do CollectionTypeService")
public class ServiceCollectionTypeTest {

  @Autowired
  CollectionTypeService service;

  @Test
  @DisplayName("01 - Testando se o service funciona corretamente")
  public void collectionService() {
    CollectionTypeCount expected = new CollectionTypeCount(new String[]{"hist"}, 387);

    CollectionTypeCount output = service.countByCollectionTypes("hist");
    assertEquals(output.getClass(), expected.getClass());
  }
}
