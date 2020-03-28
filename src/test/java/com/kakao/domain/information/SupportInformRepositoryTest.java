package com.kakao.domain.information;

import com.kakao.domain.agency.SupportAgency;
import com.kakao.domain.agency.SupportAgencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dleo9 on 2020-03-27.
 */
@SpringBootTest
public class SupportInformRepositoryTest {

    @Autowired
    private SupportAgencyRepository supportAgencyRepository;

    @Autowired
    private SupportInformRepository supportInformRepository;

    @Test
    void create(){
        //Agency create 부분
        SupportAgency supportAgency = new SupportAgency();

        supportAgency.setRegion("경상도");
        supportAgency.setRegionCode("reg1234");
        supportAgencyRepository.save(supportAgency);

        //Inform create 부분
        SupportInform supportInform = new SupportInform();
        supportInform.setRegionCode("reg1234");
        supportInform.setCreatedTimeAt(LocalDateTime.now());
        supportInform.setTarget("중소기업 청년전세대출");
        supportInform.setUsage("운전 및 시설");
        supportInform.setLimitValue("1억이내");
        supportInform.setRate("3%~5%");
        supportInform.setInstitute("경상남도");
        supportInform.setMgmt("경남지점");
        supportInform.setReception("경상남도 소재 지역");
        supportInform.setSupportAgency(supportAgency);
        supportInformRepository.save(supportInform);

        System.out.println(supportInformRepository.findAll());
        System.out.println(supportAgencyRepository.findAll());
    }
}
