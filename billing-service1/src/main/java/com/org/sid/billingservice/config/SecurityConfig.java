/*
package com.org.sid.billingservice.config;



import com.org.sid.billingservice.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private AuthService authService;

    public SecurityConfig(AuthService authService) {

        this.authService = authService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
      //  http.cors().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/h2-console/**", "/refreshToken/**").permitAll();
        // http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JwtAuthorizationFilter(authService),UsernamePasswordAuthenticationFilter.class);
    }
}
*/
