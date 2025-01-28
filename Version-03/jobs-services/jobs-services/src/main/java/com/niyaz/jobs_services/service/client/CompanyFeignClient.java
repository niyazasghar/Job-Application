package com.niyaz.jobs_services.service.client;

import com.niyaz.jobs_services.dto.CompanyDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "company", fallback = CompanyFallback.class)
public interface CompanyFeignClient {
    @Operation(summary = "Get a company by ID")
    @GetMapping("/api/companies/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) ;
}
