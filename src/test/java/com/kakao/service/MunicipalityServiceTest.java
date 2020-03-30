package com.kakao.service;

import com.kakao.domain.information.SupportInformMapping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MunicipalityServiceTest {
    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private DataInsertService dataInsertService;

    @Test
    void find(){
        dataInsertService.insertData();
        List<SupportInformMapping> supportInformMappings = municipalityService.findPretty();
        System.out.println(supportInformMappings);
    }
}
