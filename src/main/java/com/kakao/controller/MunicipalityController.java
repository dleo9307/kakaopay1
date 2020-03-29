package com.kakao.controller;

/**
 * Created by dleo9 on 2020-03-26.
 */

import com.kakao.service.DataInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {
    private final DataInsertService dataInsertService;

    public MunicipalityController(DataInsertService dataInsertService){
        this.dataInsertService = dataInsertService;
    }

    //CSV 데이터셋을 H2 데이터베이스에 저장하는 API
    @GetMapping(path="/saveDataSet")
    public void saveDataSet(){
        dataInsertService.insertData();
    }

}
