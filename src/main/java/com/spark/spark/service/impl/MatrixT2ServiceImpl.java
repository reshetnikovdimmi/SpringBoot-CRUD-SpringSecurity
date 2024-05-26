package com.spark.spark.service.impl;

import com.spark.spark.model.MatrixT2;
import com.spark.spark.repository.MatrixT2Repository;
import com.spark.spark.service.interf.MatrixT2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatrixT2ServiceImpl extends AbstractCRUDService<MatrixT2, Long>  implements MatrixT2Service {
    @Autowired
    private MatrixT2Repository matrixT2Repository;
    @Override
    CrudRepository<MatrixT2, Long> getRepository() {
        return matrixT2Repository;
    }
    @Override
    public List<MatrixT2> findAll() {
        List<String> list = matrixT2Repository.findByDistrModDist();
        List<MatrixT2> obj = new ArrayList<>();
        List<MatrixT2> objects = new ArrayList<>(matrixT2Repository.getMatrixT2());
        for (String s: list){
            MatrixT2 matrixT2 = new MatrixT2();
            matrixT2.setDistributionModel(s);
            for (MatrixT2 m:objects){
                if (s.equals(m.getDistributionModel())&&m.getCluster().equals("1"))matrixT2.setCluster1(String.valueOf(m.getQuantity()));
                if (s.equals(m.getDistributionModel())&&m.getCluster().equals("2"))matrixT2.setCluster2(String.valueOf(m.getQuantity()));
                if (s.equals(m.getDistributionModel())&&m.getCluster().equals("3"))matrixT2.setCluster3(String.valueOf(m.getQuantity()));
                if (s.equals(m.getDistributionModel())&&m.getCluster().equals("4"))matrixT2.setCluster4(String.valueOf(m.getQuantity()));
            }
            obj.add(matrixT2);
        }
        return obj;
    }
}
