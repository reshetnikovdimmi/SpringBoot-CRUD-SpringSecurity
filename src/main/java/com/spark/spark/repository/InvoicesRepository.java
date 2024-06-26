package com.spark.spark.repository;

import com.spark.spark.dto.*;
import com.spark.spark.model.Invoices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoicesRepository extends CrudRepository<Invoices, Long> {
    @Query("SELECT new com.spark.spark.dto.RemnantsSaleMarvelDto(m.ManufacturersArticle, m.Name, COUNT(i.characteristic),  COUNT(i.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<RemnantsSaleMarvelDto> remnantsSaleMarvel();

    @Query("SELECT new com.spark.spark.dto.ArticleImeiMarvelDto(m.ManufacturersArticle, s.characteristic) FROM Invoices i " +
            "LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL ")
    List<ArticleImeiMarvelDto> articleImei();

    @Query("SELECT new com.spark.spark.dto.PocoDto(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<PocoDto> remainsSalePoco();

    @Query("SELECT new com.spark.spark.dto.XiaomiDto(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic) ) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<XiaomiDto>  remainsSaleXiaomi();

    @Query("SELECT new com.spark.spark.dto.RomaDto(m.ManufacturersArticle, COUNT(r.characteristic),  COUNT(s.characteristic), COUNT(r.characteristic),  COUNT(s.characteristic)) FROM Invoices i " +
            "LEFT JOIN  i.remainsMarvel r LEFT JOIN  i.salesReport s LEFT JOIN  i.marvelClassifier m WHERE m.ManufacturersArticle IS NOT NULL GROUP BY m.ManufacturersArticle")
    List<RomaDto> romaShares();
}
