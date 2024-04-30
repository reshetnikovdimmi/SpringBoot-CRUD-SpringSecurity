package com.spark.spark.service.interf;

import java.util.List;

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
