package com.spark.spark.repository;

import com.spark.spark.dto.*;
import com.spark.spark.model.Invoices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoicesRepository extends CrudRepository<Invoices, Long> {
    @Query("SELECT new com.spark.spark.dto.RemnantsSaleMarvel(m.ManufacturersArticle, m.Name, COUNT(r.characteristic),  COUNT(s.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<RemnantsSaleMarvel> remnantsSaleMarvel();

    @Query("SELECT new com.spark.spark.dto.ArticleImeiMarvel(m.ManufacturersArticle, s.characteristic) FROM Invoices i " +
            "LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL ")
    List<ArticleImeiMarvel> articleImei();

    @Query("SELECT new com.spark.spark.dto.Poco(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<Poco> remainsSalePoco();

    @Query("SELECT new com.spark.spark.dto.Xiaomi(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic) ) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<Xiaomi>  remainsSaleXiaomi();

    @Query("SELECT new com.spark.spark.dto.Roma(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic), COUNT(r.characteristic),  COUNT(s.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<Roma> romaShares();
}
