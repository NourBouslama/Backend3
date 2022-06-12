package com.backend.caisse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws
	Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable();
	 //Demander a spring de ne pas enregistrer les sessions de travail pour les collections
	 http.sessionManagement().
	 sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//permettre a tous le monde d'acceder a la page de connection
	 http.authorizeRequests().antMatchers("/login").permitAll();
	 //pour tous les autres requette il faut une authentification 
	 http.authorizeRequests().anyRequest().authenticated();
	 http.addFilter(new JWTAuthenticationFilter (authenticationManager())) ;
	 http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	 }
    
}
