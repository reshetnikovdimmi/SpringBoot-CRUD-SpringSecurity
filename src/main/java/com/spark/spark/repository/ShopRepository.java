package com.spark.spark.repository;

import com.spark.spark.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Optional<Shop> findByLogin(String login);
}
