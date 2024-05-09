package com.spark.spark.service.reportMarvel;

import com.spark.spark.dto.*;
import com.spark.spark.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReportMarvel implements CheckingLists {

    @Autowired
    private RemainsMarvelRepository remainsMarvelRepository;

    @Autowired
    private PhoneMatrixRepository phoneMatrixRepository;

    @Autowired
    private ButtonMatrixRepository buttonMatrixRepository;

    @Autowired
    private  MarvelClassifierRepository marvelClassifierRepository;

    @Autowired
            private InvoicesRepository invoicesRepository;

    List<String> a;
    List<String> b;

    public List<String> newPhones() {

        a = remainsMarvelRepository.getRemainsSimAndModem();
        b = phoneMatrixRepository.getModelList();
        b.addAll(buttonMatrixRepository.getModelsButton());


        return subtract(a,b);

    }

    public List<String> NoClassifier() {
       List<String> a = phoneMatrixRepository.getModelListXiaomi();
       List<String> b = marvelClassifierRepository.getRainbowNomenclature();

        return subtract(a,b);
    }

    public List<RemnantsSaleMarvelDto> reportUploadPortal(Date start, Date stop) {

        return invoicesRepository.remnantsSaleMarvel();
    }

    public List<ArticleImeiMarvelDto> articleImeiList(Date start, Date stop) {

        return invoicesRepository.articleImei();
    }

    public List<PocoDto> remainsSalePoco(Date start, Date stop) {
        return invoicesRepository.remainsSalePoco();
    }

    public List<XiaomiDto> remainsSaleXiaomi(Date start, Date stop) {
        return invoicesRepository.remainsSaleXiaomi();
    }

    public List<RomaDto> romaShares(Date start, Date stop) {
        return invoicesRepository.romaShares();
    }
}
