package hu.madarasz.asteroids.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                    "https://your-framer-project.framer.app", 
                    "http://localhost:3000"
                )
                .allowedMethods("GET")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}

