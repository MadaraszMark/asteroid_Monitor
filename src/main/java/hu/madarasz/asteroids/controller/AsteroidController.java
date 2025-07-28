package hu.madarasz.asteroids.controller;

import hu.madarasz.asteroids.dto.AsteroidDto;
import hu.madarasz.asteroids.exception.InvalidRequestException;
import hu.madarasz.asteroids.service.AsteroidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asteroids")
public class AsteroidController {

    private static final Logger log = LoggerFactory.getLogger(AsteroidController.class);

    private final AsteroidService asteroidService;

    public AsteroidController(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @GetMapping
    public ResponseEntity<List<AsteroidDto>> getAsteroids(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        log.info("🔭 API hívás: aszteroidák lekérdezése {} és {} között", from, to);

        if (from.isAfter(to)) {
            throw new InvalidRequestException("A 'from' dátum nem lehet későbbi, mint a 'to' dátum.");
        }

        List<AsteroidDto> asteroids = asteroidService.getAsteroids(from, to);
        return ResponseEntity.ok(asteroids);
    }
}


