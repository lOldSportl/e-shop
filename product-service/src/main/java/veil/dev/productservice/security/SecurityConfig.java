package veil.dev.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Полностью отключаем безопасность
        http
                .csrf(AbstractHttpConfigurer::disable)           // отключаем CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // разрешаем все запросы
        return http.build();
    }
}
