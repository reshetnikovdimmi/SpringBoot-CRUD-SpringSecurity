package com.spark.spark.service.impl;

import com.spark.spark.model.Shop;
import com.spark.spark.repository.ShopRepository;
import com.spark.spark.security.ShopDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ShopDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ShopRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Shop> userOptional = userRepository.findByLogin(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new ShopDetailsImpl(userOptional.get());
    }
}
