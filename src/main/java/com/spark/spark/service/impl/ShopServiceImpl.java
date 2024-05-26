package com.spark.spark.service.impl;


import com.spark.spark.model.Shop;
import com.spark.spark.repository.ShopRepository;
import com.spark.spark.service.interf.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated

public class ShopServiceImpl extends AbstractCRUDService<Shop, Long>  implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    CrudRepository getRepository() {
        return shopRepository;
    }
    @Override
    public void create(@Validated Shop shop) throws UsernameNotFoundException {

        String encodedPassword = passwordEncoder.encode(shop.getPassword());
        shop.setPassword(encodedPassword);
        getRepository().save(shop);


    }

}
