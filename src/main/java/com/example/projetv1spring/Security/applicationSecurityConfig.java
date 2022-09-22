package com.example.projetv1spring.Security;

import com.example.projetv1spring.Auth.ApplicationUserService;
import com.example.projetv1spring.JWT.filter;
import com.example.projetv1spring.JWT.jwtTokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class applicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordEncoder;
    private ApplicationUserService dao_service;
    @Autowired
    public applicationSecurityConfig(PasswordEncoder passwordEncoder,ApplicationUserService dao_service){
        this.dao_service=dao_service;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new filter(authenticationManager()))
                .addFilterAfter(new jwtTokenVerifier(),filter.class)
                .authorizeRequests()
                .antMatchers("/clients/sign_in","/produits/free/*","/produits/free/*/*","/coperatives/free/*","/coperatives/free/*/*").permitAll()
                .anyRequest()
                .authenticated();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoprovider());
    }
    @Bean
    public DaoAuthenticationProvider daoprovider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(dao_service);
        return provider;
    }
}
