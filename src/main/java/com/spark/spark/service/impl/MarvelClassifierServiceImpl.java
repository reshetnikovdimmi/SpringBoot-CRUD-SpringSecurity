package com.spark.spark.service.impl;

import com.spark.spark.model.marvel.MarvelClassifier;
import com.spark.spark.repository.MarvelClassifierRepository;
import com.spark.spark.service.interf.MarvelClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MarvelClassifierServiceImpl extends AbstractCRUDService<MarvelClassifier, Long>  implements MarvelClassifierService {

   @Autowired
   private MarvelClassifierRepository marvelClassifierRepository;
    @Override
    CrudRepository<MarvelClassifier, Long> getRepository() {
        return marvelClassifierRepository;
    }
}
