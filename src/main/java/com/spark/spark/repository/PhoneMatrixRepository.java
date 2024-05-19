package com.spark.spark.repository;


import com.spark.spark.service.util.mapper.MappingUtils;
import com.spark.spark.model.PhoneMatrix;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PhoneMatrixRepository extends CrudRepository<PhoneMatrix, Long> {
    @Query("SELECT DISTINCT model FROM PhoneMatrix")
    List<String> getListModel();

    @Query("SELECT DISTINCT name FROM PhoneMatrix")
    List<String> getListName();

    @Query("SELECT DISTINCT y_name  FROM PhoneMatrix WHERE model = ?1")
    List<String> getListY_name(String model);

    @Query("SELECT DISTINCT brand  FROM PhoneMatrix WHERE y_name = ?1")
    List<String> getListBrand(String y_name);

    @Modifying
    @Transactional
    @Query("update PhoneMatrix u set u.name = ?1 where u.name = ?2")
    void updateName(String s, String s1);

    @Query("SELECT DISTINCT distributionModel  FROM PhoneMatrix")
    List<String> getModelList();

    @Query("SELECT distributionModel  FROM PhoneMatrix WHERE model = 'PocoDto' OR model = 'XiaomiDto'")
    List<String> getModelListXiaomi();

    @Query("SELECT DISTINCT new com.spark.spark.service.util.mapper.MappingUtils(r.shop,p.name,p.distributionModel,r.remains)" +
            " FROM PhoneMatrix p" +
            " LEFT JOIN p.remainsList r")
    List<MappingUtils> getRemains();

    @Query("SELECT DISTINCT new com.spark.spark.service.util.mapper.MappingUtils(r.shop,p.name,p.distributionModel,r.sale)" +
            " FROM PhoneMatrix p" +
            " LEFT JOIN p.sale1List r ")
    List<MappingUtils> getSale1();

    @Query("SELECT new com.spark.spark.service.util.mapper.MappingUtils(r.shop,p.name,p.distributionModel,r.sale)" +
            " FROM PhoneMatrix p" +
            " LEFT JOIN p.sale6List r")
    List<MappingUtils> getSale6();
}
