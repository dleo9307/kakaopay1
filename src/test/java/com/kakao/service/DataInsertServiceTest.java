package com.kakao.service;

import com.kakao.domain.information.SupportInformRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInsertServiceTest {
    @Autowired
    private DataInsertService dataInsertService;

    @Autowired
    SupportInformRepository supportInformRepository;

    @Test
    void csvInsert(){
        dataInsertService.insertData();

        System.out.println(supportInformRepository.findAll());
    }
}
