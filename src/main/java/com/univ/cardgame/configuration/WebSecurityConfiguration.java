package com.univ.cardgame.configuration;

import com.univ.cardgame.service.AccountService;
import com.univ.cardgame.util.JwtAuthenticationEntryPoint;
import com.univ.cardgame.util.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthEntryPoint;

  @Autowired
  private AccountService jwtUserDetailsService;

  @Autowired
  private JwtFilter jwtFilter;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  private static final String[] ROUTES_WHITELIST = {
      // API
      "/account/register",
      "/account/login"
  };

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(jwtUserDetailsService).passwordEncoder(bcryptEncoder);
  }


  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeRequests()
        .antMatchers(ROUTES_WHITELIST).permitAll().anyRequest().authenticated().and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint).and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    httpSecurity.cors();
  }
}
