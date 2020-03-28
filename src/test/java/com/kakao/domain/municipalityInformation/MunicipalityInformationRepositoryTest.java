package com.kakao.domain.municipalityInformation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * Created by dleo9 on 2020-03-27.
 */
@SpringBootTest
class MunicipalityInformationRepositoryTest{

    @Autowired
    private MunicipalityInformationRepository municipalityInformationRepository;

    @Test
    void create(){
        MunicipalityInformation municipalityInformation = new MunicipalityInformation();
        municipalityInformation.setRegionCode("reg1234");
        municipalityInformation.setCreatedTimeAt(LocalDateTime.now());
        municipalityInformation.setTarget("중소기업 청년전세대출");
        municipalityInformation.setUsage("운전 및 시설");
        municipalityInformation.setLimitValue("1억이내");
        municipalityInformation.setRate("3%~5%");
        municipalityInformation.setInstitute("경상남도");
        municipalityInformation.setMgmt("경남지점");
        municipalityInformation.setReception("경상남도 소재 지역");

        municipalityInformationRepository.save(municipalityInformation);

        System.out.println(municipalityInformationRepository.findAll());
    }
}
