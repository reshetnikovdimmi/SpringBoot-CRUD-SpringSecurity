package com.spark.spark.repository;

import com.spark.spark.model.Invoices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoicesRepository extends CrudRepository<Invoices, Long> {

}
