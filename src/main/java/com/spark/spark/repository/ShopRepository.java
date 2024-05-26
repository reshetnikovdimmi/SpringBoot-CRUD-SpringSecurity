package com.spark.spark.repository;

import com.spark.spark.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

    Optional<Shop> findByLogin(String login);

    @Query("SELECT shopIskra  FROM Shop WHERE clusterIskra != ''")
    List<String> multListShop();

    @Query("SELECT shopIskra  FROM Shop WHERE clusterT2 != ''")
    List<String> monoListShop();

    @Query("SELECT shopIskra  FROM Shop ")
    List<String> getShopList();
}
