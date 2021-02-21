/*
package com.org.sid.billingservice.config;

import com.auth0.jwt.interfaces.DecodedJWT;

import com.org.sid.billingservice.service.AuthService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private AuthService authService;

    public JwtAuthorizationFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getServletPath().equals("/refreshToken")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            String auth = httpServletRequest.getHeader(AuthService.AUTHORIZATION_HEADER);
            if (auth != null && auth.startsWith(AuthService.AUTHORIZATION_HEADER_START)) {
                try {
                    String jwt = auth.substring(AuthService.AUTHORIZATION_HEADER_START.length());
                    DecodedJWT decodedJWT = authService.verifyToken(jwt);
                    String userName = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userName, null, convert(roles));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    httpServletResponse.setHeader("error-message", e.getMessage());
                    httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
    }

    Collection<GrantedAuthority> convert(String[] roles) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
*/
