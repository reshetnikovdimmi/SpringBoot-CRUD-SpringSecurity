package com.spark.spark.repository;

import com.spark.spark.model.ButtonMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
//TODO: если делаем extends JpaRepository то @Repository кажется не нужно
public interface ButtonMatrixRepository extends JpaRepository<ButtonMatrix, Long> {

   @Query("SELECT new com.spark.spark.model.ButtonMatrix(p.id, p.model, p.brand, r.prices) FROM ButtonMatrix p " +
            "LEFT JOIN p.prices r ORDER BY p.id ASC")
    List<ButtonMatrix> getButtonMatrixPrice();

    @Query("SELECT DISTINCT model  FROM ButtonMatrix")
    List<String> getModelsButton();
}
