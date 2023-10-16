package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
//			      .permitAll())
//			      .csrf(AbstractHttpConfigurer::disable);
		
//		http.authorizeHttpRequests(
//				(requests) -> requests
//								.requestMatchers("/", "/api/user/encrypt-psd").permitAll()
//								.anyRequest().authenticated()).cors().and().csrf().disable();

		http.authorizeHttpRequests(
				(requests) -> requests
						.requestMatchers("/", "/api/user/encrypt-psd").permitAll()
						.requestMatchers("/", "/api/user/register").permitAll()
						.requestMatchers("/", "/api/user/login").permitAll()
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
						.anyRequest().authenticated()).cors().and().csrf().disable();

		return http.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
