package com.spark.spark.repository;


import com.spark.spark.model.Remains;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemainsRepository extends CrudRepository<Remains, Long> {

}
