package com.example.projetv1spring.JWT;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class jwtTokenVerifier extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header=request.getHeader("Authorization");
        System.out.println(header);
        if(Strings.isNullOrEmpty(header)||!header.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String secondToken=header.replace("Bearer ","");
        System.out.println(secondToken);
        try{
            String key="iznvidzotuma53tvm08lkudaq3mbvvvcserrdsqzxs42113f57j9kfc";
            Jws<Claims> claimsJws= Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key))).parseClaimsJws(secondToken);
            Claims body=claimsJws.getBody();
            String username=body.getSubject();
            var authorities=(List<Map<String,String>>) body.get("authorities");
            Set<SimpleGrantedAuthority> granted = authorities.stream()
                    .map(m->new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());
            Authentication authentication=new UsernamePasswordAuthenticationToken
                    (username,null,granted);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (JwtException e){
            throw new IllegalStateException(secondToken.toString()+" error asadi9i f token");
        }
        filterChain.doFilter(request,response);
    }
}
