package com.dialafrika.whatsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // You may want to restrict this to specific domains in a production environment
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // Or whatever methods you need to allow
                .allowedHeaders("*") ;// Or whatever headers you need to allow
    }
}
