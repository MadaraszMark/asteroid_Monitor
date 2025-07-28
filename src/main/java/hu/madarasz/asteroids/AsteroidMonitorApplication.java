package hu.madarasz.asteroids;

import hu.madarasz.asteroids.config.NasaApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NasaApiProperties.class)
public class AsteroidMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsteroidMonitorApplication.class, args);
    }
}


