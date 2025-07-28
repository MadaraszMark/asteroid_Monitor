package hu.madarasz.asteroids.test.controller;

import hu.madarasz.asteroids.controller.AsteroidController;
import hu.madarasz.asteroids.service.AsteroidService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsteroidController.class)
class AsteroidControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsteroidService asteroidService;

    @Test
    void testGetAsteroids_validDates_returnsOk() throws Exception {
        when(asteroidService.getAsteroids(any(), any())).thenReturn(List.of());

        mockMvc.perform(get("/api/asteroids")
                        .param("from", "2025-01-01")
                        .param("to", "2025-01-02"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAsteroids_invalidDateRange_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/asteroids")
                        .param("from", "2025-01-05")
                        .param("to", "2025-01-01"))
                .andExpect(status().isBadRequest());
    }
}

