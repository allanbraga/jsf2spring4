package com.app.main.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http
	  	.csrf().disable()
	  	.authorizeRequests()
		.antMatchers("/pages/**").authenticated()
		.and().formLogin()
		.loginPage("/login.xhtml")
		.loginProcessingUrl("/login")
		.usernameParameter("login")
		.passwordParameter("password")
		.defaultSuccessUrl("/pages/home.xhtml")
		.and().logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login.xhtml");
	  
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth
	  	.jdbcAuthentication().dataSource(dataSource)
	  	.usersByUsernameQuery("select login,password,status from user where login = ? ")
	  	.authoritiesByUsernameQuery("select login,role from user where login = ? ")
	  	.passwordEncoder(encoder());
	  
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder(11);
	}
}
