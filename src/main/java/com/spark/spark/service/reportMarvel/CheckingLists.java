package com.spark.spark.service.reportMarvel;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;

public interface CheckingLists {
    default List<String> subtract (List<String> a, List<String> b){
        Collection<String> subtract = CollectionUtils.subtract(a, b);
        return (List<String>) subtract;
    }

}


