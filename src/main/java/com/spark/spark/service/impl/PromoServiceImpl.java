package com.spark.spark.service.impl;

import com.spark.spark.model.Promo;
import com.spark.spark.repository.PromoRepository;
import com.spark.spark.service.interf.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PromoServiceImpl extends AbstractCRUDService<Promo, Long> implements PromoService {
    @Autowired
    private PromoRepository promoRepository;

    private List<Promo> today;
    private List<Promo> yesterday;

    @Override
    CrudRepository<Promo, Long> getRepository() {
        return promoRepository;
    }


    public Object startPromo() {
        return todayStartEndPromo(today, yesterday);
    }

    public Object endPromo() {
        return todayStartEndPromo(yesterday, today);
    }

    public Object promoExtension() {
        return extensionTodayPromo(today, yesterday);
    }

    private Object todayStartEndPromo(List<Promo> today, List<Promo> yesterday) {
        List<Promo> promoList = new ArrayList<>();
        for (Promo t : today) {
            if (yesterday.stream()
                    .filter(y -> t.getModels().equals(y.getModels()))
                    .findAny()
                    .orElse(null) == null) {
                promoList.add(t);
            }
        }
        return promoList;
    }

    private Object extensionTodayPromo(List<Promo> today, List<Promo> yesterday) {
        List<Promo> promoList = new ArrayList<>();
        for (Promo t : today) {
            if (yesterday.stream()
                    .filter(y -> t.getModels().equals(y.getModels()))
                    .findAny()
                    .orElse(null) != null) {
                promoList.add(t);
            }
        }
        return promoList;
    }

    public void loadTodayYesterday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        today = promoRepository.startPromo(date);
        yesterday = promoRepository.endPromo(new java.sql.Date(cal.getTime().getTime()));
    }
}
