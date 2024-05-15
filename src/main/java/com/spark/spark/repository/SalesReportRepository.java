package com.spark.spark.repository;

import com.spark.spark.model.SalesReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesReportRepository extends CrudRepository<SalesReport, Long> {
    @Query("SELECT new com.spark.spark.model.SalesReport (s.characteristic, s.shop, s.nomenclature,  s.dateSale, p.suppliers, m.brand) FROM SalesReport s " +
            "LEFT JOIN  s.provider p JOIN  s.phoneMatrix m WHERE s.dateSale>=?1 AND (?2 is null or s.dateSale<=?2) AND m.model IS NOT NULL AND p.suppliers IS NOT NULL")
    List<SalesReport> salesReport(LocalDate now, LocalDate nowed);
}
