package com.niyaz.company_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyCreateDTO {
    @NotBlank(message = "Company name is required")
    private String name;

    @Size(max = 500, message = "Description can be up to 500 characters")
    private String description;

    private String industry;

    private String website;

    private String logoUrl;

    private String location;
}