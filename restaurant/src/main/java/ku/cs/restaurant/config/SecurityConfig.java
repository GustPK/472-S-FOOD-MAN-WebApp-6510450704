package ku.cs.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                .requestMatchers(HttpMethod.PATCH, "/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/**").permitAll()
            )
            .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
