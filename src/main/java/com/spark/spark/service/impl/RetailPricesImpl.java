package com.spark.spark.service.impl;


import com.spark.spark.model.RetailPrices;
import com.spark.spark.model.Suppliers;
import com.spark.spark.repository.RetailPricesRepository;
import com.spark.spark.repository.SuppliersRepository;
import com.spark.spark.service.interf.RetailPricesService;
import com.spark.spark.service.interf.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RetailPricesImpl extends AbstractCRUDService<RetailPrices, Long>  implements RetailPricesService {
    @Autowired
    //TODO: модификатор private?
    RetailPricesRepository retailPricesRepository;


    @Override
    CrudRepository getRepository() {
        return retailPricesRepository;
    }



    }

