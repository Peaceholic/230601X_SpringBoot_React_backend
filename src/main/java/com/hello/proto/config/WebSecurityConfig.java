package com.hello.proto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hello.proto.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	protected SecurityFilterChain conficure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// cors 정책 기본사용
				.cors().and()
				// csrf 비활성화
				.csrf().disable()
				// BearerToken 사용으로 비활성화
				.httpBasic().disable()
				// Session 기반 인증을 사용하지 않기 때문에 상태를 제거 
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				//
				.authorizeRequests().requestMatchers("/", "/api/auth/**").permitAll()
				//
				.anyRequest().authenticated();

		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}

}
