package com.niyaz.jobs_services.service.client;

import com.niyaz.jobs_services.dto.ReviewDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("reviews")
public interface ReviewsFeignClient {
    @Operation(summary = "Get reviews by Company ID")
    @GetMapping("/api/reviews/company/{companyId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByCompanyId(@PathVariable Long companyId);
}
