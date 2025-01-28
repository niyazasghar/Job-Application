package com.niyaz.jobs_services.service.client;


import com.niyaz.jobs_services.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyFallback implements CompanyFeignClient{


    @Override
    public ResponseEntity<CompanyDTO> getCompanyById(Long id) {
        return null;
    }
}
