package hu.madarasz.asteroids.test.service;

import hu.madarasz.asteroids.client.NasaApiClient;
import hu.madarasz.asteroids.dto.AsteroidDto;
import hu.madarasz.asteroids.service.impl.AsteroidServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AsteroidServiceImplTest {

    @Mock
    private NasaApiClient nasaApiClient;

    @InjectMocks
    private AsteroidServiceImpl asteroidService;

    @Test
    void testGetAsteroids_returnsExpectedList() {
        LocalDate from = LocalDate.of(2025, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 2);
        List<AsteroidDto> mockData = List.of(new AsteroidDto());

        when(nasaApiClient.fetchAsteroids(from, to)).thenReturn(mockData);

        List<AsteroidDto> result = asteroidService.getAsteroids(from, to);

        assertEquals(mockData, result);
        verify(nasaApiClient).fetchAsteroids(from, to);
    }
}

