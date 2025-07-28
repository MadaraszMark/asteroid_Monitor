package hu.madarasz.asteroids.service;

import hu.madarasz.asteroids.dto.AsteroidDto;

import java.time.LocalDate;
import java.util.List;

public interface AsteroidService {

    List<AsteroidDto> getAsteroids(LocalDate startDate, LocalDate endDate);
}

