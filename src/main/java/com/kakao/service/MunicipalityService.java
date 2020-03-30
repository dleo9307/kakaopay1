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

    public SupportInform findByRegion(String region){
        return supportInformRepository.findBySupportAgencyRegion(region);
    }

    public SupportInform updateByRegion(final String region, final SupportInform reqObj){
        SupportInform supportInform = findByRegion(region);

        supportInform.setTargetValue(reqObj.getTargetValue());
        supportInform.setSupportAgency(reqObj.getSupportAgency());
        supportInform.setMgmt(reqObj.getMgmt());
        supportInform.setInstitute(reqObj.getInstitute());
        supportInform.setRate(reqObj.getRate());
        supportInform.setLimitValue(reqObj.getLimitValue());
        supportInform.setUsage(reqObj.getUsage());
        supportInform.setReception(reqObj.getReception());
        supportInform.setSupportAgency(reqObj.getSupportAgency());

        return supportInformRepository.save(supportInform);
    }

}
