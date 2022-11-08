package com.tein8.easybus.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    
        http
            .httpBasic()
            .and()
            .authorizeHttpRequests()
                // Onibus
                .antMatchers(HttpMethod.GET, "/api/onibus/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/onibus").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/onibus").hasRole("ADMIN")

                // Usuários
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/user/**").authenticated()
                
                // Infra
                .antMatchers("/h2-console/**").permitAll()
                
               
                .anyRequest().permitAll()
            .and()
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            //.and()
                .formLogin()
                //.loginPage("/minhapaginadelogin")
        ;

       return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
