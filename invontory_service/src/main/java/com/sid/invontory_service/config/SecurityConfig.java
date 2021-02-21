/*
package com.sid.invontory_service.config;


import com.sid.invontory_service.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String role="hasAuthority('ADMIN') or hasAuthority('PRODUCTS_MANAGER')";
    private AuthService authService;

    public SecurityConfig(AuthService authService) {

        this.authService = authService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/produits/**").access(role)
                .antMatchers(HttpMethod.DELETE,"/produits/**").access(role)
                .antMatchers(HttpMethod.PUT,"/produits/**").access(role);
        // http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JwtAuthorizationFilter(authService),UsernamePasswordAuthenticationFilter.class);
    }
}
*/
