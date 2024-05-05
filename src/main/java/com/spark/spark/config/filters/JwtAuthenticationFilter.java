package com.spark.spark.config.filters;

import com.spark.spark.service.JwtTokenService;
import com.spark.spark.service.impl.ShopDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private ShopDetailsServiceImpl myCustomUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // GET AUTHENTICATION HEADER:
        String authHeader = request.getHeader("Authorization");
        // SET JWT PROPERTY:

        String jwtToken = null;
        // SET USERNAME PROPERTY:
        String login = null;

        // CHECK / VALIDATE AUTHORIZATION HEADER:
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            // KILL CODE EXECUTION HERE:
            return;
        }


        // SET JWT TOKEN VALUE RETRIEVED FROM AUTHORIZATION HEADER:
        jwtToken = authHeader.substring(7);

        // EXTRACT THE USER EMAIL FROM JWT TOKEN:
        login = jwtTokenService.extractUsername(jwtToken);

        // CHECK IF USER NOT NULL AND IS AUTHENTICATED:
        if(login != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails =  myCustomUserDetailService.loadUserByUsername(login);

            // VALIDATE TOKEN:
            if(jwtTokenService.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken userAuthToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                userAuthToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
