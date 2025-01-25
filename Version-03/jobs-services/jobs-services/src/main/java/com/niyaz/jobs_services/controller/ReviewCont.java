package com.niyaz.jobs_services.controller;

import com.niyaz.jobs_services.dto.ReviewDTO;
import com.niyaz.jobs_services.service.FeignReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Review-Related", description = "InterService Communication")
@RestController
@RequestMapping("/api")
public class ReviewCont {

    @Autowired
    FeignReviewService feignReviewService;

    @Operation(
            summary = "Fetch reviews for a specific company",
            description = "This endpoint returns a list of reviews for a company identified by the companyId."
    )
    @GetMapping("/fetchReviews/{companyId}")
    public ResponseEntity<List<ReviewDTO>> fetchReviewDetails(@PathVariable long companyId){
        List<ReviewDTO> reviewDTOS = feignReviewService.fetchAllReviews(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(reviewDTOS);
    }
}
