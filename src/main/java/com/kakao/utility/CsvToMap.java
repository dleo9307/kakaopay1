package com.kakao.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvToMap {
    private String path;
    private CSVReader reader;
    private List<Map> mapList;

    public CsvToMap(String path) {
        this.path = path;
        mapList = new ArrayList<>();
    }

    /**
     * @apiNote csv데이터를 읽어서 맵에 매핑시킨후 맵을 리스트에 추가하는 기능
     * @param startLine csv데이터를 읽기 시작할 위치
     * @param header csv의 Header정보
     */
    public void setMapList(long startLine, String[] header) {
        try {
            reader = new CSVReader(new FileReader(path));
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                if (reader.getLinesRead() < startLine) continue;
                if (header.length != nextLine.length) throw new CsvValidationException("Error Line : " + reader.getLinesRead());

                Map<String, Object> mapObj = new HashMap<>();
                for(int i=0; i<header.length; i++){
                    mapObj.put(header[i], nextLine[i]);
                }
                mapList.add(mapObj);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO ERROR : " + e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("CSV VALIDATION ERROR : " + e.getMessage());
        }
    }

    //List 객체를 리턴한다.
    public List<Map> getMapList(){
        return mapList;
    }
}
