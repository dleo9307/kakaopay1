package com.kakao.service;

import com.kakao.domain.agency.SupportAgency;
import com.kakao.domain.agency.SupportAgencyRepository;
import com.kakao.domain.information.SupportInform;
import com.kakao.domain.information.SupportInformRepository;
import com.kakao.utility.CsvHeaderInform;
import com.kakao.utility.CsvToMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataInsertService {
    @Autowired
    private SupportInformRepository supportInformRepository;

    @Autowired
    private SupportAgencyRepository supportAgencyRepository;

    private CsvToMap csvToMap;
    private List<SupportAgency> supportAgencies;
    private List<SupportInform> supportInforms;
    private Map<String, SupportAgency> uniqRegionCode;

    public boolean insertData() {
        try {
            csvToMap = new CsvToMap(new ClassPathResource("./data/사전과제1.csv").getFile().toString());
            csvToMap.setMapList(2, CsvHeaderInform.header);

            List<Map> CsvObjList = csvToMap.getMapList();
            uniqRegionCode = new HashMap<>();

            supportInforms = new ArrayList<>();
            supportAgencies = new ArrayList<>();

            int uniqCount = 1;
            for (Map obj : CsvObjList) {
                SupportInform supportInform = new SupportInform();

                if (!uniqRegionCode.containsKey(obj.get("region"))) {
                    SupportAgency supportAgency = new SupportAgency();
                    supportAgency.setRegion(obj.get("region").toString());
                    supportAgency.setRegionCode("reg" + uniqCount);
                    supportAgencies.add(supportAgency);
                    uniqRegionCode.put(obj.get("region").toString(), supportAgency);
                    uniqCount++;
                }

                supportInform.setSupportAgency(uniqRegionCode.get(obj.get("region")));
                supportInform.setId(Long.parseLong(obj.get("id").toString()));
                supportInform.setTarget(obj.get("target").toString());
                supportInform.setUsage(obj.get("usage").toString());
                supportInform.setLimitValue(obj.get("limitValue").toString());
                supportInform.setRate(obj.get("rate").toString());
                supportInform.setInstitute(obj.get("institute").toString());
                supportInform.setMgmt(obj.get("mgmt").toString());
                supportInform.setReception(obj.get("reception").toString());

                supportInforms.add(supportInform);
            }
            supportAgencyRepository.saveAll(supportAgencies);
            supportInformRepository.saveAll(supportInforms);
            return true;
        } catch (IOException e) {
            System.out.println("IO ERROR : " + e.getMessage());
            return false;
        }
    }
}
