package com.niyaz.company_services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanyDTO {
    private Long id;
    private String name;
    private String description;
    private String industry;
    private String website;
    private String logoUrl;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}