package hu.madarasz.asteroids.service.impl;

import hu.madarasz.asteroids.client.NasaApiClient;
import hu.madarasz.asteroids.dto.AsteroidDto;
import hu.madarasz.asteroids.service.AsteroidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsteroidServiceImpl implements AsteroidService {

    private static final Logger log = LoggerFactory.getLogger(AsteroidServiceImpl.class);

    private final NasaApiClient nasaApiClient;

    public AsteroidServiceImpl(NasaApiClient nasaApiClient) {
        this.nasaApiClient = nasaApiClient;
    }

    @Override
    public List<AsteroidDto> getAsteroids(LocalDate startDate, LocalDate endDate) {
        log.debug("📡 AsteroidServiceImpl: lekérés {} és {} között", startDate, endDate);
        return nasaApiClient.fetchAsteroids(startDate, endDate);
    }
}


