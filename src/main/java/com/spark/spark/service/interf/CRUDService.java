package com.spark.spark.service.interf;

import java.util.List;
//TODO: для интерфейсов можно не создать подпаке "interf". Они могут лежать в пакете service, а их
//имплементации в пакете impl
public interface CRUDService<E, K> {

    void create(E entity);

    E findById(K id);

    List<E> findAll();

    E update(E entity);

    void delete(E entity);

    void deleteById(K id);

    void deleteAll();

    List<E> saveAll(List<E> l);


}
