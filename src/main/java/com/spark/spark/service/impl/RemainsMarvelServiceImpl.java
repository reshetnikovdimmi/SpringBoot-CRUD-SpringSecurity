package com.spark.spark.service.impl;

import com.spark.spark.model.Promo;
import com.spark.spark.model.marvel.RemainsMarvel;
import com.spark.spark.repository.RemainsMarvelRepository;
import com.spark.spark.service.interf.PromoService;
import com.spark.spark.service.interf.RemainsMarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RemainsMarvelServiceImpl extends AbstractCRUDService<RemainsMarvel, Long>  implements RemainsMarvelService {
    @Autowired
    private RemainsMarvelRepository remainsMarvelRepository;

    @Override
    CrudRepository<RemainsMarvel, Long> getRepository() {
        return remainsMarvelRepository;
    }
}
