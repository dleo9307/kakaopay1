package com.kakao.service;

import com.kakao.domain.information.SupportInformRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CsvSaveServiceTest {
    @Autowired
    private CsvSaveService csvSaveService;

    @Autowired
    SupportInformRepository supportInformRepository;

    @Test
    void csvInsert(){
        csvSaveService.insertData();
        System.out.println(supportInformRepository.findAll());
    }
}
