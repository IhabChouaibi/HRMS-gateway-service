package pfa.dev.gatewayservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

//@Configuration
public class WebConfig {

   // @Bean
    public CorsWebFilter corsWebFilter() {
        // Configuration CORS
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowCredentials(true);
        // ⭐ DEV (Angular local)
        corsConfig.addAllowedOrigin("http://localhost:4200");

        // ⭐ Docker frontend
        corsConfig.addAllowedOrigin("http://frontend");

        // ⭐ Methods
        corsConfig.addAllowedMethod("*");

        // ⭐ Headers
        corsConfig.addAllowedHeader("*");

        // ⭐ Exposed headers
        corsConfig.addExposedHeader("Authorization");
        // Mapping pour toutes les routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
