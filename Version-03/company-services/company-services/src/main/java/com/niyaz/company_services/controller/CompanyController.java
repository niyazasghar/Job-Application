package com.niyaz.company_services.controller;

import com.niyaz.company_services.dto.CompanyContactInfoDto;
import com.niyaz.company_services.dto.CompanyCreateDTO;
import com.niyaz.company_services.dto.CompanyDTO;
import com.niyaz.company_services.dto.CompanyUpdateDTO;
import com.niyaz.company_services.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@Tag(name = "Companies", description = "APIs for managing companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "Create a new company")
    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@Validated @RequestBody CompanyCreateDTO companyCreateDTO) {
        CompanyDTO createdCompany = companyService.createCompany(companyCreateDTO);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a company by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        return ResponseEntity.ok(companyDTO);
    }

    @Operation(summary = "Get all companies")
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @Operation(summary = "Update a company by ID")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @Validated @RequestBody CompanyUpdateDTO companyUpdateDTO) {
        CompanyDTO updatedCompany = companyService.updateCompany(id, companyUpdateDTO);
        return ResponseEntity.ok(updatedCompany);
    }

    @Operation(summary = "Delete a company by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search companies")
    @GetMapping("/search")
    public ResponseEntity<List<CompanyDTO>> searchCompanies(@RequestParam("query") String query) {
        List<CompanyDTO> companies = companyService.searchCompanies(query);
        return ResponseEntity.ok(companies);
    }

    @Autowired
    private Environment environment;

    @Autowired
    private CompanyContactInfoDto companyContactInfoDto;

    @GetMapping("/contact-info")
    public ResponseEntity<CompanyContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyContactInfoDto);
    }
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

}
