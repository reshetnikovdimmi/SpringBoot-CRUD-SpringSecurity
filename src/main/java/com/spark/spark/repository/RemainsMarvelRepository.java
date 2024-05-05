package com.spark.spark.repository;


import com.spark.spark.model.marvel.RemainsMarvel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemainsMarvelRepository extends CrudRepository<RemainsMarvel, Long> {
    @Query("SELECT DISTINCT nomenclature  FROM RemainsMarvel")
    List<String> getRemainsSimAndModem();
}
