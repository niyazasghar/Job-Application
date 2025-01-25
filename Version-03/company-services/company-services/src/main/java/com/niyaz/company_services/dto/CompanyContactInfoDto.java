package com.niyaz.company_services.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "company")
@Component
public class CompanyContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;

    public CompanyContactInfoDto() {
        System.out.println("CompanyContactInfoDto initialized with message: " + message);
    }
}
