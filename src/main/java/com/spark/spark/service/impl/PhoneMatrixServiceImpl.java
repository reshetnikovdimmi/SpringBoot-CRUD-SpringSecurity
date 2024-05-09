package com.spark.spark.service.impl;


import com.spark.spark.model.PhoneMatrix;
import com.spark.spark.repository.PhoneMatrixRepository;
import com.spark.spark.service.interf.PhoneMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneMatrixServiceImpl extends AbstractCRUDService<PhoneMatrix, Long>  implements PhoneMatrixService {
    @Autowired
   private PhoneMatrixRepository phoneMatrixRepository;
    @Override
    CrudRepository<PhoneMatrix, Long> getRepository() {
        return phoneMatrixRepository;
    }
}
