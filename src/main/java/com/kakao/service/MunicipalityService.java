package com.kakao.service;

import com.kakao.domain.agency.SupportAgencyRepository;
import com.kakao.domain.information.SupportInform;
import com.kakao.domain.information.SupportInformRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {

    private final SupportInformRepository supportInformRepository;
    private final SupportAgencyRepository supportAgencyRepository;

    public MunicipalityService(SupportInformRepository supportInformRepository, SupportAgencyRepository supportAgencyRepository){
        this.supportInformRepository = supportInformRepository;
        this.supportAgencyRepository = supportAgencyRepository;
    }

    public List<SupportInform> findAll(){
        return supportInformRepository.findAll();
    }

    public SupportInform findByRegion(String region){
        return supportInformRepository.findBySupportAgencyRegion(region);
    }

    public SupportInform updateByRegion(final String region, final SupportInform reqObj){
        SupportInform supportInform = findByRegion(region);
        if(supportInform == null) return null;

        if(reqObj.getTargetValue() != null) supportInform.setTargetValue(reqObj.getTargetValue());
        if(reqObj.getSupportAgency() != null) supportAgencyRepository.save(reqObj.getSupportAgency());
        if(reqObj.getMgmt() != null) supportInform.setMgmt(reqObj.getMgmt());
        if(reqObj.getInstitute() != null) supportInform.setInstitute(reqObj.getInstitute());
        if(reqObj.getRate() != null) supportInform.setRate(reqObj.getRate());
        if(reqObj.getLimitValue() != null) supportInform.setLimitValue(reqObj.getLimitValue());
        if(reqObj.getUsage() != null) supportInform.setUsage(reqObj.getUsage());
        if(reqObj.getReception() != null) supportInform.setReception(reqObj.getReception());
        return supportInformRepository.save(supportInform);
    }

}
