package se.remchii.musicsharingapi.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import se.remchii.musicsharingapi.property.Auth0Properties;

import java.util.Arrays;

@EnableWebSecurity
@EnableConfigurationProperties(Auth0Properties.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Auth0Properties properties;

    public SecurityConfig(Auth0Properties properties) {
        this.properties = properties;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(properties.getApiAudience(), properties.getIssuer())
                .configure(http)
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}
