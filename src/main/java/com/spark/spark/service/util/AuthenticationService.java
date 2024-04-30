package com.spark.spark.service.util;

import com.spark.spark.model.Shop;
import com.spark.spark.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> listShop() {
        List<Shop> objects = new ArrayList<>();
        shopRepository.findAll().forEach(objects::add);
        return objects;
    }

    public Shop identification() {
        Shop s = new Shop();
        s.setPassword("65156156");
        s.setLogin("jbyubyuu");
        return s;
    }
}
