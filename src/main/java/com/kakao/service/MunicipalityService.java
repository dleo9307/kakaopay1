package com.kakao.service;

import com.kakao.domain.information.SupportInform;
import com.kakao.domain.information.SupportInformRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {

    private final SupportInformRepository supportInformRepository;

    public MunicipalityService(SupportInformRepository supportInformRepository){
        this.supportInformRepository = supportInformRepository;
    }

    public List<SupportInform> findAll(){
        return supportInformRepository.findAll();
    }

}
