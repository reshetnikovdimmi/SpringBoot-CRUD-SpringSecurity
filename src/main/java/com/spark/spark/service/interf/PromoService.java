package com.spark.spark.service.interf;

import com.spark.spark.model.Promo;

//TODO: для интерфейсов можно не создать подпаке "interf". Они могут лежать в пакете service, а их
//имплементации в пакете impl
public interface PromoService extends CRUDService<Promo, Long>{
}
