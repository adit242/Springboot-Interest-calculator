package com.interest.calculator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("jayee").password("{noop}password").roles("ADMIN") .and()
	 * .withUser("test").password("{noop}password").roles("ADMIN");
	 * 
	 * }
	 */
    
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable().headers().frameOptions().sameOrigin();
    }
    
   
}