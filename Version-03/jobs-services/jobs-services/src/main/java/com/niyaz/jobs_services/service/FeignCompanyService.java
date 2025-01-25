package com.niyaz.jobs_services.service;


import com.niyaz.jobs_services.dto.CompanyDTO;
import com.niyaz.jobs_services.service.client.CompanyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class FeignCompanyService {
    @Autowired
    CompanyFeignClient companyFeignClient;
    public CompanyDTO fetchCompanyById(Long companyID) {
        ResponseEntity<CompanyDTO> companyDTOResponseEntity=companyFeignClient.getCompanyById(companyID);
        return CompanyMapper(companyDTOResponseEntity);
    }
    public CompanyDTO CompanyMapper(ResponseEntity<CompanyDTO> companyDTOResponseEntity){
        CompanyDTO companyDTO = new CompanyDTO();
        CompanyDTO body = companyDTOResponseEntity.getBody();

        if (body != null) {
            companyDTO.setId(body.getId());
            companyDTO.setName(body.getName());
            companyDTO.setDescription(body.getDescription());
            companyDTO.setIndustry(body.getIndustry());
            companyDTO.setWebsite(body.getWebsite());
            companyDTO.setLogoUrl(body.getLogoUrl());
            companyDTO.setLocation(body.getLocation());
            companyDTO.setCreatedAt(body.getCreatedAt());
            companyDTO.setUpdatedAt(body.getUpdatedAt());
        }
        return companyDTO;
    }

}
