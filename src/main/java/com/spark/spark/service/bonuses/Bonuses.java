package com.spark.spark.service.bonuses;

import com.spark.spark.model.Promo;
import com.spark.spark.model.SalesReport;
import com.spark.spark.repository.PromoRepository;
import com.spark.spark.repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class Bonuses {
    @Autowired
    private SalesReportRepository salesReport;
    @Autowired
    private PromoRepository promoRepository;
    List<Promo> promos;
    List<SalesReport> reports;

    public Object getAllBonuses(LocalDate now, LocalDate nowed) {
        promos = new ArrayList<>();
        reports = (List<SalesReport>) salesReport.salesReport(now,nowed);
        promos = (List<Promo>) promoRepository.findAll();
        reports.forEach(s -> s.setCompensation(searchCompensation(s.getDateSale(), s.getModels())));
        return reports.stream().collect((groupingBy(SalesReport::getSuppliers, Collectors.summingDouble(SalesReport::getCompensation))));
    }

    private Double searchCompensation(Date dateSale, String models) {
        for (Promo p : promos) {
            if (models.equals(p.getModels()) && dateSale.after(p.getStartPromo()) && dateSale.before(p.getEndPromo())) {
                return Double.valueOf(p.getCompensation());
            }
            if (models.equals(p.getModels()) && dateSale.equals(p.getStartPromo()) || dateSale.equals(p.getEndPromo())) {
                return Double.valueOf(p.getCompensation());
            }
        }
        return 0.0;
    }

    public Object getAllBonuse() {

        return reports;
    }
}
