package com.kakao.service;

import com.kakao.domain.information.SupportInform;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MunicipalityServiceTest {
    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private CsvSaveService csvSaveService;

    @Test
    void find(){
        csvSaveService.insertData();
        List<SupportInform> supportInformMappings = municipalityService.findAll();
        System.out.println(supportInformMappings);
    }
}
