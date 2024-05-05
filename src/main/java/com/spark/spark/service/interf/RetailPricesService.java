package com.spark.spark.service.interf;

import com.spark.spark.model.RetailPrices;
//TODO: для интерфейсов можно не создать подпаке "interf". Они могут лежать в пакете service, а их
//имплементации в пакете impl
public interface RetailPricesService extends CRUDService<RetailPrices, Long>{
}
