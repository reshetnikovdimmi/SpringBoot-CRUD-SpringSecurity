package com.spark.spark.service.util.mapper;

import com.spark.spark.model.AllSalesShop;
import java.util.List;

public interface CreateDTO {
    default int getRemainsSale1Sale6(String shops, String names, String distributionModels, List<MappingUtils> mappingUtils) {
        return mappingUtils.stream().filter(r -> r.getShop() != null && r.getShop().equals(shops) && r.getName().equals(names) && r.getDistributionModel().equals(distributionModels)).mapToInt(MappingUtils::getQuantity).sum();
    }
    default int getRemainsSumModelShop(String m, String s,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(s) && r.getName().equals(m)).mapToInt(AllSalesShop::getRemains).sum();
    }
    default int remainsCashDistrModel(String distributionModel, String s,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(s) && r.getDistributionModel().equals(distributionModel)).mapToInt(AllSalesShop::getRemains). sum();
    }
    default int getSale1ModelShop(String m, String s,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(s) && r.getName().equals(m)).mapToInt(AllSalesShop::getSale1).sum();
    }
    default int getSale6ModelShop(String m, String s,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(s) && r.getName().equals(m)).mapToInt(AllSalesShop::getSale6).sum();
    }

    default int getOrderModelShop(String m, String s,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(s) && r.getName().equals(m)).mapToInt(AllSalesShop::getOrder).sum();
    }

    default int searchSale6(String m,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(m)).mapToInt(AllSalesShop::getSale6).sum();
    }

    default int searchSale1(String m,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(m)).mapToInt(AllSalesShop::getSale1).sum();
    }

    default int searchRemains(String m,List<AllSalesShop> allSalesShops) {
        return allSalesShops.stream().filter(r ->r.getShop()!=null && r.getShop().equals(m)).mapToInt(AllSalesShop::getRemains).sum();
    }
    default int getSearchMatrixT2(String s, String shop,List<AllSalesShop> matrixT2) {
        return matrixT2.stream().filter(r ->r.getShop()!=null && r.getShop().equals(shop) && r.getName().equals(s)).mapToInt(AllSalesShop::getRemainsCash2).sum();
    }
}
