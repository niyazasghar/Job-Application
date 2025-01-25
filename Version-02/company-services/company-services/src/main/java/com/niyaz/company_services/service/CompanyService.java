package com.niyaz.company_services.service;


import com.niyaz.company_services.dto.CompanyCreateDTO;
import com.niyaz.company_services.dto.CompanyDTO;
import com.niyaz.company_services.dto.CompanyUpdateDTO;
import com.niyaz.company_services.entity.Company;
import com.niyaz.company_services.exception.ResourceNotFoundException;
import com.niyaz.company_services.repositoy.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CompanyDTO createCompany(CompanyCreateDTO companyCreateDTO) {
        Company company = modelMapper.map(companyCreateDTO, Company.class);
        Company savedCompany = companyRepository.save(company);
        return modelMapper.map(savedCompany, CompanyDTO.class);
    }

    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
        return modelMapper.map(company, CompanyDTO.class);
    }

    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    public CompanyDTO updateCompany(Long id, CompanyUpdateDTO companyUpdateDTO) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
        existingCompany.setName(companyUpdateDTO.getName());
        existingCompany.setDescription(companyUpdateDTO.getDescription());
        existingCompany.setIndustry(companyUpdateDTO.getIndustry());
        existingCompany.setWebsite(companyUpdateDTO.getWebsite());
        existingCompany.setLogoUrl(companyUpdateDTO.getLogoUrl());
        existingCompany.setLocation(companyUpdateDTO.getLocation());

        Company updatedCompany = companyRepository.save(existingCompany);
        return modelMapper.map(updatedCompany, CompanyDTO.class);
    }

    public void deleteCompany(Long id) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + id));
        companyRepository.delete(existingCompany);
    }

    public List<CompanyDTO> searchCompanies(String query) {
        // Implement search logic using specifications or query methods
        // Placeholder: return all companies
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }
}