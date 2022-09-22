package com.example.projetv1spring.JWT;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class filter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager manager;
    public filter(AuthenticationManager manager){
        this.manager=manager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {
        try {
            request_user request_user=new ObjectMapper().readValue(request.getInputStream(),request_user.class);
            Authentication authentication=new UsernamePasswordAuthenticationToken(
                    request_user.getUsername(),
                    request_user.getPassword()
            );
            Authentication my_result=manager.authenticate(authentication);
            return my_result;
        } catch (IOException e) {
            System.out.println("im fucked");
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)
            throws IOException, ServletException {
        String key="iznvidzotuma53tvm08lkudaq3mbvvvcserrdsqzxs42113f57j9kfc";
        String token= Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
                .compact();
        System.out.println(token);
        response.addHeader("Authorization","Bearer "+token);
    }

}
