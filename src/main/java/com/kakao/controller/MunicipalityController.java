package com.kakao.controller;

/**
 * Created by dleo9 on 2020-03-26.
 */

import com.kakao.domain.information.SupportInform;
import com.kakao.service.CsvSaveService;
import com.kakao.service.MunicipalityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {

    private final CsvSaveService csvSaveService;
    private final MunicipalityService municipalityService;

    public MunicipalityController(CsvSaveService csvSaveService, MunicipalityService municipalityService){
        this.csvSaveService = csvSaveService;
        this.municipalityService = municipalityService;
    }


    //CSV 데이터셋을 데이터베이스에 저장하는 API
    @GetMapping(path="/saveDataSet")
    public ResponseEntity<String> saveDataSet(){
        if(municipalityService.findAll().size() > 0){
            return new ResponseEntity("Already inserted", HttpStatus.BAD_REQUEST);
        }else{
            csvSaveService.insertData();
            return new ResponseEntity("success", HttpStatus.OK);
        }
    }

    //모든 지자체 목록을 조회하는 APi
    @GetMapping(path = "/findAll")
    public ResponseEntity<List> findAll(){
        return new ResponseEntity(municipalityService.findAll(), HttpStatus.OK);
    }


    //지자체 이름으로 목록을 조회하는 API
    @GetMapping(path = "/findByRegion")
    public ResponseEntity<SupportInform> findByRegion(@RequestParam HashMap<String,Object> req){
        return new ResponseEntity(municipalityService.findByRegion(req.get("region").toString()), HttpStatus.OK);
    }
}
