package com.niyaz.jobs_services.controller;

import com.niyaz.jobs_services.dto.CompanyDTO;
import com.niyaz.jobs_services.service.FeignCompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Company-Related", description = "InterService Communication")

@RestController
@RequestMapping("/api")
public class CompanyCont {

    @Autowired
    FeignCompanyService feignCompanyService;

    @Operation(
            summary = "Fetch company details by ID",
            description = "Fetch detailed information about a company using its ID"
    )
    @GetMapping("/fetchCompanyDetails/{companyID}")
    public ResponseEntity<CompanyDTO> fetchCompanyDetails(@PathVariable Long companyID){
        CompanyDTO companyDTO = feignCompanyService.fetchCompanyById(companyID);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(companyDTO);
    }
}
