/*
package com.sid.invontory_service.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {
    public static final String SECRET="mySecret3045";
    public static final String AUTHORIZATION_HEADER ="Authorization";
    public static final String AUTHORIZATION_HEADER_START ="Bearer ";
    public static final long ACCESS_TOKEN_EXPIRE=2*60*1000;
    public static final long REFRESH_TOKEN_EXPIRE=15*60*1000;
    private static final Algorithm algorithm=Algorithm.HMAC256(AuthService.SECRET);
    public void sendTokens(String jwtAccessToken, String refreshToken, HttpServletResponse httpServletResponse) throws IOException {
        Map<String, String> idToken = new HashMap<>();
        idToken.put("access-token", jwtAccessToken);
        idToken.put("refresh-token", refreshToken);
        new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), idToken);
        httpServletResponse.setHeader(AuthService.AUTHORIZATION_HEADER, jwtAccessToken);
    }
    public String createAccessToken(String userName, HttpServletRequest request, List<String> roles ) {
        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+ AuthService.ACCESS_TOKEN_EXPIRE))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",roles)
                .sign(algorithm);
    }
    public String createRefreshToken(String userName, HttpServletRequest request){
      return   JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+AuthService.REFRESH_TOKEN_EXPIRE))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
    }
    public DecodedJWT  verifyToken(String jwt){

        Algorithm algorithm = Algorithm.HMAC256(AuthService.SECRET);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
       return  jwtVerifier.verify(jwt);
    }

}
*/
