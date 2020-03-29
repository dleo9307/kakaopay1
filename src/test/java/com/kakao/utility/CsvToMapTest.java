package com.kakao.utility;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.List;
import java.util.Map;

class CsvToMapTest {
    private CsvToMap csvToMap;
    private ClassPathResource resource;
    private List<Map> testList;

    @Test
    void readCsv() throws Exception{
        resource = new ClassPathResource("./data/사전과제1.csv");
        csvToMap = new CsvToMap(resource.getFile().toString());

        csvToMap.setMapList(2, CsvHeaderInform.header);
        testList = csvToMap.getMapList();

        System.out.println(testList);
    }
}
