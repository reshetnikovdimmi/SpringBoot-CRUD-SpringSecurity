package com.spark.spark.repository;

import com.spark.spark.model.Promo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
//TODO: если делаем extends CrudRepository то @Repository кажется не нужно
public interface PromoRepository extends CrudRepository<Promo, Long> {
    @Query("SELECT new com.spark.spark.model.Promo (id, brend, y_name, models, price, price_promo,  startPromo, endPromo, compensation) FROM Promo WHERE (?1 is null or brend=?1) AND (?2 is null or y_name=?2) AND (?3 is null or models=?3) AND (?4 is null or startPromo=?4) AND (?5 is null or endPromo=?5) ORDER BY startPromo DESC")
    List<Promo> searchPromo(String brend, String y_name, String models, Date startPromo, Date endPromo);
    @Query("SELECT new com.spark.spark.model.Promo (id, brend, y_name, models, price, price_promo,  startPromo, endPromo, compensation) FROM Promo WHERE startPromo <=?1 AND endPromo >=?1")
    List<Promo> currentPromo(Date date);
    @Query("SELECT new com.spark.spark.model.Promo (id, brend, y_name, models, price, price_promo,  startPromo, endPromo, compensation) FROM Promo WHERE endPromo =?1")
    List<Promo> endPromo(Date date);
    @Query("SELECT new com.spark.spark.model.Promo (id, brend, y_name, models, price, price_promo,  startPromo, endPromo, compensation) FROM Promo WHERE startPromo =?1")
    List<Promo>startPromo(Date date);

}
