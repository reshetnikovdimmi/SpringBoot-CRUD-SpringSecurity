package com.spark.spark.service.util.mapper;

import com.spark.spark.model.AllSalesShop;
import org.hibernate.annotations.Comment;

import java.util.*;
import java.util.stream.Collectors;

@Comment("spring")
public class Matrix<T> {




    public List getMatrix(List<MappingUtils> remains, List<AllSalesShop> matrixT2ShopMulti, List<String> shopList) {
        List<T> matrix = new ArrayList<>();
        matrixT2ShopMulti.forEach(r -> r.setRemains(getRemainsSumModelShop(remains, r.getShop(), r.getName())));
        LinkedHashSet<T> r = new LinkedHashSet<>();
        r.add((T) "TT");
        for (AllSalesShop a : matrixT2ShopMulti) {
            r.add((T) a.getName());
        }
        r.add((T) "Итого");

        matrix.add((T) r);
        for (String s : shopList) {
            List<String> ry = new ArrayList<>();

            ry.add(s);
            for (AllSalesShop a : matrixT2ShopMulti) {
                if (a.getShop() != null && s.equals(a.getShop())) {
                    ry.add((a.getRemainsCash2() == 0 ? "ЛОЖЬ" : String.format("%.0f", (double) a.getRemains() / (double) a.getRemainsCash2() * 100 > 100 ? 100 : (double) a.getRemains() / (double) a.getRemainsCash2() * 100)));
                }
            }

            List<String> russ = new ArrayList<>(ry);
            russ.remove(0);
            List<Integer> rus = russ.stream().filter(t -> !Objects.equals(t, "ЛОЖЬ")).map(Integer::valueOf).collect(Collectors.toList());
            OptionalDouble i = rus.stream().mapToDouble(Integer::intValue).average();
            ry.add(String.format("%.0f", i.getAsDouble()));
            matrix.add((T) ry);
        }
        return matrix;
    }

    public List getMatrixSt(List<MappingUtils> remains, List<AllSalesShop> matrixT2ShopMulti, List<String> shopList) {
        List<T> matrix = new ArrayList<>();
        matrixT2ShopMulti.forEach(r -> r.setRemains(getRemainsSumModelShop(remains, r.getShop(), r.getName())));
        LinkedHashSet<T> r = new LinkedHashSet<>();
        r.add((T) "TT");
        for (AllSalesShop a : matrixT2ShopMulti) {
            r.add((T) a.getName());
        }

        matrix.add((T) r);
        for (String s : shopList) {
            List<String> rys = new ArrayList<>();

            rys.add(s);

            for (AllSalesShop a : matrixT2ShopMulti) {
                if (a.getShop() != null && s.equals(a.getShop())) {
                    rys.add( a.getRemains() +"/" + a.getRemainsCash2() );
                }
            }

            matrix.add((T) rys);
        }
        return matrix;
    }

    private int getRemainsSumModelShop(List<MappingUtils> remains, String m, String s) {
        return remains.stream().filter(r -> r.getShop() != null && r.getShop().equals(m) && r.getName().equals(s)).mapToInt(MappingUtils::getQuantity).sum();
    }
}
