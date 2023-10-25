package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Teste para get museum/id")
public class GetMuseumByIdTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  MuseumService service;

  @Test
  @DisplayName("Testando se getMuseum/id funciona corretamente")
  void testGetMuseumById() throws Exception {
    long id = 1;
    Coordinate coord = new Coordinate(12.34, 23.45);
    Museum muse = new Museum();
    muse.setId(id);
    muse.setName("aaa");
    muse.setDescription("bbb");
    muse.setAddress("rua");
    muse.setCollectionType("ccc");
    muse.setSubject("ddd");
    muse.setCoordinate(coord);
    muse.setUrl("eee");
    muse.setLegacyId(id);
    Mockito
        .when(service.getMuseum(id))
        .thenReturn(muse);

    mockMvc.perform(
        get("/museums/1")
        .accept(MediaType.APPLICATION_JSON)
      )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("aaa"));

    Mockito.verify(service).getMuseum(id);
    Mockito.verify(service, times(1)).getMuseum(id);
    Mockito.reset(service);
  }


}
