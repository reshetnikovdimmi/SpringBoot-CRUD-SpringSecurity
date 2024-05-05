package com.spark.spark.service.interf;


import com.spark.spark.model.marvel.RemainsMarvel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//TODO: для интерфейсов можно не создать подпаке "interf". Они могут лежать в пакете service, а их
//имплементации в пакете impl
public interface RemainsMarvelService extends CRUDService<RemainsMarvel, Long>{

}
