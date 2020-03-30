package com.kakao.domain.information;

import com.kakao.domain.agency.SupportAgency;
import com.kakao.domain.agency.SupportAgencyRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Created by dleo9 on 2020-03-27.
 */
@SpringBootTest
class SupportInformRepositoryTest {

    @Autowired
    private SupportAgencyRepository supportAgencyRepository;

    @Autowired
    private SupportInformRepository supportInformRepository;

    @Test
    void create(){
        SupportAgency supportAgency = new SupportAgency();
        supportAgency.setRegion("경상도");
        supportAgency.setRegionCode("reg1234");
        supportAgencyRepository.save(supportAgency);

        SupportInform supportInform = new SupportInform();
        supportInform.setTargetValue("중소기업 청년전세대출");
        supportInform.setUsage("운전 및 시설");
        supportInform.setLimitValue("1억이내");
        supportInform.setRate("3%~5%");
        supportInform.setInstitute("경상남도");
        supportInform.setMgmt("경남지점");
        supportInform.setReception("경상남도 소재 지역");
//        supportInform.setSupportAgency(supportAgency);
        supportInform.setRegionCode(supportAgency.getRegionCode());
        supportInformRepository.save(supportInform);

        System.out.println(supportInformRepository.findAll());
        System.out.println(supportAgencyRepository.findAll());
    }


    @Test
    void updateCase1(){
        SupportAgency supportAgency = supportAgencyRepository.findAll().get(0);
        supportAgency.setRegion("TEST");
        supportAgencyRepository.save(supportAgency);

        System.out.println(supportAgencyRepository.findAll());
        System.out.println(supportInformRepository.findAll());
    }


//    @Test
//    void updateCase2(){
//        SupportInform supportInform = supportInformRepository.findAll().get(0);
//
//        SupportAgency supportAgency = supportInform.getSupportAgency();
//        supportAgency.setRegion("TEST2");
//        supportAgencyRepository.save(supportAgency);
//
//        System.out.println(supportAgencyRepository.findAll());
//        System.out.println(supportInformRepository.findAll());
//    }

}
