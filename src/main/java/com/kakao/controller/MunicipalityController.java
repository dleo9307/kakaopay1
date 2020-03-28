package com.kakao.controller;

/**
 * Created by dleo9 on 2020-03-26.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {

    //CSV 데이터셋을 H2 데이터베이스에 저장하는 API
    @GetMapping(path="/saveDataSet")
    public String saveDataSet(){
        return "Hello world";
    }


}
