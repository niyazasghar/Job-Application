package com.niyaz.jobs_services.service.client;


import com.niyaz.jobs_services.dto.CompanyDTO;
import com.niyaz.jobs_services.dto.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewFallback implements ReviewsFeignClient{

    @Override
    public ResponseEntity<List<ReviewDTO>> getReviewsByCompanyId(Long companyId) {
        return null;
    }
}
