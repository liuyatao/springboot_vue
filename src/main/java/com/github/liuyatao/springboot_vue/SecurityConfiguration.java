package com.github.liuyatao.springboot_vue;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().permitAll()

      .and().authorizeRequests()
      .antMatchers("/").authenticated()
      .anyRequest().authenticated();
  }


  @Override
  public void configure(WebSecurity web) throws Exception {
    web.debug(true);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
      .and().withUser("admin").password("admin").roles("ADMIN");
  }
}
