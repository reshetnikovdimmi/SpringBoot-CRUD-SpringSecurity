package com.spark.spark.repository;


import com.spark.spark.model.marvel.RemainsMarvel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemainsMarvelRepository extends CrudRepository<RemainsMarvel, Long> {
}
