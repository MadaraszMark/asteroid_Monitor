package hu.madarasz.asteroids.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.madarasz.asteroids.config.NasaApiProperties;
import hu.madarasz.asteroids.dto.AsteroidDto;
import hu.madarasz.asteroids.exception.ExternalApiException;

@Component
public class NasaApiClient {

    private static final Logger log = LoggerFactory.getLogger(NasaApiClient.class);

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final String apiKey;

    public NasaApiClient(NasaApiProperties nasaProps) {
        this.apiKey = nasaProps.getKey();
        this.objectMapper = new ObjectMapper();

        this.webClient = WebClient.builder()
                .baseUrl(nasaProps.getUrl())
                .build();

        log.info("✅ NasaApiClient initialized with base URL: {}", nasaProps.getUrl());
    }

    public List<AsteroidDto> fetchAsteroids(LocalDate startDate, LocalDate endDate) {
        String uri = String.format("?start_date=%s&end_date=%s&api_key=%s", startDate, endDate, apiKey);
        String responseBody;

        try {
            responseBody = webClient.get()
                    .uri(uri)
                    .retrieve()
                    .onStatus(
                    	    status -> status.isError(),
                    	    clientResponse -> clientResponse.bodyToMono(String.class)
                    	        .map(body -> new ExternalApiException("NASA API hiba: " + body))
                    	        .cast(Throwable.class)
                    	)

                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            log.error("🌐 NASA API válaszhiba: {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw new ExternalApiException("NASA API válaszhiba", e);
        } catch (Exception e) {
            log.error("🚨 Hiba történt a NASA API hívás közben", e);
            throw new ExternalApiException("Nem sikerült lekérni az adatokat a NASA API-tól", e);
        }

        return parseAsteroids(responseBody);
    }

    private List<AsteroidDto> parseAsteroids(String responseBody) {
        List<AsteroidDto> result = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode nearEarthObjects = root.path("near_earth_objects");

            for (Iterator<String> it = nearEarthObjects.fieldNames(); it.hasNext(); ) {
                String date = it.next();
                JsonNode asteroids = nearEarthObjects.get(date);

                for (JsonNode asteroidNode : asteroids) {
                    AsteroidDto dto = extractAsteroidDto(asteroidNode);
                    if (dto != null) {
                        result.add(dto);
                    }
                }
            }
        } catch (Exception e) {
            log.error("❌ JSON feldolgozási hiba a NASA API válasznál", e);
            throw new ExternalApiException("Hibás NASA API válasz", e);
        }

        return result;
    }

    private AsteroidDto extractAsteroidDto(JsonNode node) {
        try {
            String name = node.path("name").asText();
            boolean isHazardous = node.path("is_potentially_hazardous_asteroid").asBoolean();

            JsonNode diameterNode = node.path("estimated_diameter").path("meters");
            double minDiameter = diameterNode.path("estimated_diameter_min").asDouble();
            double maxDiameter = diameterNode.path("estimated_diameter_max").asDouble();

            JsonNode approachArray = node.path("close_approach_data");
            if (!approachArray.isArray() || approachArray.isEmpty()) {
                return null;
            }

            JsonNode approach = approachArray.get(0);
            double velocity = Double.parseDouble(approach.path("relative_velocity").path("kilometers_per_second").asText());
            double missDistance = Double.parseDouble(approach.path("miss_distance").path("kilometers").asText());

            return new AsteroidDto(name, minDiameter, maxDiameter, velocity, missDistance, isHazardous);

        } catch (Exception e) {
            log.warn("⚠️ Egy aszteroida elem feldolgozása nem sikerült", e);
            return null;
        }
    }
}



