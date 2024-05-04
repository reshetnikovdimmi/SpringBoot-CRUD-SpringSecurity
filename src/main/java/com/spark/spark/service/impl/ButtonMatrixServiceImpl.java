package com.spark.spark.service.impl;


import com.spark.spark.model.ButtonMatrix;
import com.spark.spark.repository.ButtonMatrixRepository;
import com.spark.spark.service.interf.ButtonMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButtonMatrixServiceImpl extends AbstractCRUDService<ButtonMatrix, Long>  implements ButtonMatrixService {
    @Autowired
    private ButtonMatrixRepository buttonMatrixRepository;
    @Override
    CrudRepository<ButtonMatrix, Long> getRepository() {
        return buttonMatrixRepository;
    }

    @Override
    public List<ButtonMatrix> findAll() {
        List<ButtonMatrix> objects = buttonMatrixRepository.getButtonMatrixPrice();
        return objects;
    }
}
