package com.example.springWeekTwo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
@EnableWebMvc
public class CorsConfig  implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                        .allowedOrigins(
                                "http://localhost:5173", //vue
                                "http://localhost:3000",  // ReactJS
                                "http://localhost:8081",  // React Native
                                "http://localhost:4200",  // Angular
                                "http://localhost:3001"   // Next.js
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
    }
}