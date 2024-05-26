package com.spark.spark.service.util.mapper;

import com.spark.spark.dto.DistributionDto;
import com.spark.spark.model.*;
import com.spark.spark.repository.ShopRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MappingUtils implements Serializable, CreateDTO {

    public static final String CASH_1 = "Центральный склад (Головань А. С.) (Головань А. С.)";
    public static final String CASH_2 = "Центральный склад Tele2 (Головань А. С.) (Головань А. С.)";

    private String shop;
    private String name;
    private String distributionModel;
    private Integer quantity;

    private List<MappingUtils> remainsList;
    private List<MappingUtils> sale1List;
    private List<MappingUtils> sale6List;
    private List<AllSalesShop> allSalesShops;
    private List<AllSalesShop> matrixT2;
    private List<PhoneMatrix> phoneMatrix;
    private List<String> model;
    private List<String> shopMono;
    private List<String> shopMulti;

    private DistributionDto distributionDto = new DistributionDto();

    @Autowired
    private ShopRepository shopRepository;

    public MappingUtils(String shop, String name, String distributionModel, Integer quantity) {
        this.shop = shop;
        this.name = name;
        this.distributionModel = distributionModel;
        this.quantity = quantity;
    }
    public void createAllSalesShops(){
        allSalesShops = new ArrayList<>();
        for (String shop : shopRepository.getShopList()) {
            for (PhoneMatrix p : phoneMatrix) {
                allSalesShops.add(new AllSalesShop(shop, p.getName(), p.getDistributionModel(), getRemainsSale1Sale6(shop, p.getName(), p.getDistributionModel(), remainsList), getRemainsSale1Sale6(shop, p.getName(), p.getDistributionModel(), sale1List), getRemainsSale1Sale6(shop, p.getName(), p.getDistributionModel(), sale6List), remainsCashDistrModel(p.getDistributionModel(), CASH_1, allSalesShops), remainsCashDistrModel(p.getDistributionModel(), CASH_2, allSalesShops)));
            }
        }
    }

    public DistributionDto createDto() {

        List<Cash> remainsCash = new ArrayList<>();
        for (String m : model) {
            remainsCash.add(new Cash(m, getRemainsSumModelShop(m, CASH_1, allSalesShops), getRemainsSumModelShop(m, CASH_2, allSalesShops)));
        }
        distributionDto.setRemainsCash(remainsCash);

        distributionDto.setIndicatorsShopMult(getIndicatorShop(shopMulti));

        distributionDto.setIndicatorsShopList(getIndicatorShop(shopMono));

        Matrix matrix = new Matrix();
        distributionDto.setMatrix(matrix.getMatrix(remainsList, matrixT2, shopMulti));
        distributionDto.setMatrix1(matrix.getMatrixSt(remainsList, matrixT2, shopMulti));

        return distributionDto;
    }

    public List<IndicatorsShop> getIndicatorShop(List<String> shop) {
        List<IndicatorsShop> indicatorsShopList = new ArrayList<>();
        for (String m : shop) {
            int remains = searchRemains(m, allSalesShops);
            int sale1 = searchSale1(m, allSalesShops);
            int sale6 = searchSale6(m, allSalesShops) / 3;
            int requirement = Math.max(sale1, sale6);

            indicatorsShopList.add(new IndicatorsShop(m, remains, sale1, sale6, requirement));
        }
        return indicatorsShopList;
    }

    public Object getModelDistributionCash(String group) {
        List<Cash> sum = new ArrayList<>();
        for (PhoneMatrix p : phoneMatrix) {
            if (p.getName().equals(group))
                sum.add(new Cash(p.getDistributionModel(),
                        remainsCashDistrModel(p.getDistributionModel(), CASH_1, allSalesShops),
                        remainsCashDistrModel(p.getDistributionModel(), CASH_2, allSalesShops)));
        }
        distributionDto.setNameCash(sum);
        return distributionDto.getNameCash();
    }


    public Object getModelDistributionShop(String group) {
        List<IndicatorsShop> sum = new ArrayList<>();
        for (String s : shopRepository.getShopList()) {
            sum.add(new IndicatorsShop(s,
                    getRemainsSumModelShop(group, s, allSalesShops),
                    getSale1ModelShop(group, s, allSalesShops),
                    getSale6ModelShop(group, s, allSalesShops),
                    0));
        }
        return sum;
    }

    public Object getAllShop(String shop) {
        List<AllSalesShop> sum = new ArrayList<>();

        for (String s : model) {

            sum.add(new AllSalesShop(shop,
                    s,
                    null,
                    getRemainsSumModelShop(s, shop, allSalesShops),
                    getSale1ModelShop(s, shop, allSalesShops),
                    getSale6ModelShop(s, shop, allSalesShops),
                    getOrderModelShop(s, shop, allSalesShops),
                    0,
                    getSearchMatrixT2(s, shop, matrixT2),
                    allSalesShops.stream().filter(r -> r.getShop().equals(shop) && r.getName().equals(s)).collect(Collectors.toList())));
        }
        sum.forEach(r -> r.setRemainsCash1(Math.max(r.getSale1(), r.getSale6() / 3)));
        distributionDto.setAllSalesShopList(sum);
        return sum;

    }

    public Object distributionDto(AllSalesShop object) {

        for (int i = 0; i < allSalesShops.size(); i++) {
            if (allSalesShops.get(i).getName().equals(object.getName())&&allSalesShops.get(i).getDistributionModel().equals(object.getDistributionModel())) {

                if(allSalesShops.get(i).getShop().equals(CASH_1)){
                    allSalesShops.get(i).setRemains(allSalesShops.get(i).getRemains()-object.getOrder());
                }

                allSalesShops.get(i).setRemainsCash1(allSalesShops.get(i).getRemainsCash1()-object.getOrder());

                if(allSalesShops.get(i).getShop().equals(object.getShop())){
                    allSalesShops.get(i).setOrder(object.getOrder());
                    allSalesShops.get(i).setRemains(allSalesShops.get(i).getRemains()+object.getOrder());
                }
            }
        }

        createDto();
        getModelDistributionCash(object.getName());
        getModelDistributionShop(object.getName());
        getAllShop(object.getShop());
        return distributionDto;

    }

}
