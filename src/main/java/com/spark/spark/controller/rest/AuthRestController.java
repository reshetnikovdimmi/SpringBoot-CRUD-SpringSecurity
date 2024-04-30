package com.spark.spark.controller.rest;

import com.spark.spark.model.Shop;
import com.spark.spark.responses.AuthResponse;
import com.spark.spark.security.ShopDetailsImpl;
import com.spark.spark.service.JwtTokenService;
import com.spark.spark.service.impl.ShopDetailsServiceImpl;
import com.spark.spark.service.impl.ShopServiceImpl;
import com.spark.spark.service.util.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
public class AuthRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private ShopDetailsServiceImpl shopDetailsService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity signIn(@RequestBody Shop loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));


        ShopDetailsImpl shopDetails =
                (ShopDetailsImpl) shopDetailsService.loadUserByUsername(loginRequest.getLogin());

        SecurityContextHolder.getContext().setAuthentication(authentication);


        String token = jwtTokenService.generateToken(shopDetails);


        AuthResponse response = new AuthResponse(token, shopDetails);


        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/LoginAndroid")
    public ResponseEntity<List<String>> loginAndroid() {
        List<String> shop = new ArrayList<>();
        authenticationService.listShop().forEach(r->shop.add(r.getLogin()));
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }
}
