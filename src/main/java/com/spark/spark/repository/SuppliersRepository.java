package com.spark.spark.repository;


import com.spark.spark.model.Suppliers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SuppliersRepository extends CrudRepository<Suppliers, Long> {
    @Query("SELECT DISTINCT name FROM Suppliers")
    List<String> getListSuppliers();
}
