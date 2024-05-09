package com.spark.spark.service.impl;


import com.spark.spark.model.Suppliers;
import com.spark.spark.repository.SuppliersRepository;
import com.spark.spark.service.interf.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuppliersServiceImpl extends AbstractCRUDService<Suppliers, Long>  implements SuppliersService {
    @Autowired
    private SuppliersRepository suppliersRepository;
    private @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    CrudRepository getRepository() {
        return suppliersRepository;
    }



    }

