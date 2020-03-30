package com.kakao.controller;

/**
 * Created by dleo9 on 2020-03-26.
 */

import com.kakao.domain.information.SupportInform;
import com.kakao.domain.information.SupportInformMapping;
import com.kakao.service.DataInsertService;
import com.kakao.service.MunicipalityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {
    private final DataInsertService dataInsertService;
    private final MunicipalityService municipalityService;

    public MunicipalityController(DataInsertService dataInsertService, MunicipalityService municipalityService){
        this.dataInsertService = dataInsertService;
        this.municipalityService = municipalityService;
    }

    //CSV 데이터셋을 데이터베이스에 저장하는 API
    @GetMapping(path="/saveDataSet")
    public ResponseEntity<String> saveDataSet(){
        if(municipalityService.findAll().size() > 0){
            return new ResponseEntity("Already inserted", HttpStatus.BAD_REQUEST);
        }else{
            dataInsertService.insertData();
            return new ResponseEntity("success", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List> findAll(){
        return new ResponseEntity(municipalityService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findPretty")
    public ResponseEntity<List> findPretty(){
        return new ResponseEntity(municipalityService.findPretty(), HttpStatus.OK);
    }
}
