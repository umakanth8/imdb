package com.example.Movie.demo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins("http://localhost:3000") // Replace with your allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the allowed HTTP methods
                .allowedHeaders("*"); // You can specify allowed headers or use "*" for all headers.
    }
}

