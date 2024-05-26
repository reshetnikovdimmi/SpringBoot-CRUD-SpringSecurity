package com.spark.spark.repository;

import com.spark.spark.model.AllSalesShop;
import com.spark.spark.model.MatrixT2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatrixT2Repository extends CrudRepository<MatrixT2, Long> {
    @Query("SELECT DISTINCT distributionModel  FROM MatrixT2")
    List<String> findByDistrModDist();

    @Query("SELECT new com.spark.spark.model.MatrixT2 (distributionModel, cluster, quantity) FROM MatrixT2")
    List<MatrixT2> getMatrixT2();


   @Query("SELECT new com.spark.spark.model.AllSalesShop (p.shopIskra, s.distributionModel, s.quantity) FROM MatrixT2 s " +
            "LEFT JOIN  s.shopMulti p ")
    List<AllSalesShop> getMatrixT2ShopMulti();

    @Query("SELECT new com.spark.spark.model.AllSalesShop (p.shopIskra, s.distributionModel, s.quantity) FROM MatrixT2 s " +
            "LEFT JOIN  s.shopMono p ")
    List<AllSalesShop> getMatrixT2ShopMono();
}
