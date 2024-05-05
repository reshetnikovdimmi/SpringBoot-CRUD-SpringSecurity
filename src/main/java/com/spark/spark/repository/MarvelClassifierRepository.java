package com.spark.spark.repository;

import com.spark.spark.model.marvel.MarvelClassifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarvelClassifierRepository extends CrudRepository<MarvelClassifier, Long> {
    @Query("SELECT RainbowNomenclature FROM MarvelClassifier")
    List<String> getRainbowNomenclature();
}
