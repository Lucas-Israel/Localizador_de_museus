package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Req 08 - collection type controller")
public class CollectionTypeTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  CollectionTypeService service;

  @Test
  @DisplayName("Testando controller collection type.")
  void testController() throws Exception {
    CollectionTypeCount collection = new CollectionTypeCount(new String[]{"hist", "imag"}, 2);
    Mockito
        .when(service.countByCollectionTypes("hist, imag"))
        .thenReturn(collection);

    mockMvc.perform(
          get("/collections/count/hist, imag")
          .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.count").value(2));

    Mockito.verify(service).countByCollectionTypes("hist, imag");
    Mockito.verify(service, times(1)).countByCollectionTypes("hist, imag");
    Mockito.reset(service);
  }
}
