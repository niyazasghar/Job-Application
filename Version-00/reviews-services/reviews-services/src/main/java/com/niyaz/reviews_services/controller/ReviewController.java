package com.niyaz.reviews_services.controller;
import com.niyaz.reviews_services.dto.ReviewCreateDTO;
import com.niyaz.reviews_services.dto.ReviewDTO;
import com.niyaz.reviews_services.dto.ReviewUpdateDTO;
import com.niyaz.reviews_services.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Reviews", description = "APIs for managing reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Operation(summary = "Create a new review")
    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@Validated @RequestBody ReviewCreateDTO reviewCreateDTO) {
        ReviewDTO createdReview = reviewService.createReview(reviewCreateDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a review by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        ReviewDTO reviewDTO = reviewService.getReviewById(id);
        return ResponseEntity.ok(reviewDTO);
    }

    @Operation(summary = "Get all reviews")
    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Get reviews by Company ID")
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByCompanyId(@PathVariable Long companyId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByCompanyId(companyId);
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Get reviews by Job ID")
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByJobId(@PathVariable Long jobId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByJobId(jobId);
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Update a review by ID")
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @Validated @RequestBody ReviewUpdateDTO reviewUpdateDTO) {
        ReviewDTO updatedReview = reviewService.updateReview(id, reviewUpdateDTO);
        return ResponseEntity.ok(updatedReview);
    }

    @Operation(summary = "Delete a review by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search reviews")
    @GetMapping("/search")
    public ResponseEntity<List<ReviewDTO>> searchReviews(@RequestParam("keyword") String keyword) {
        List<ReviewDTO> reviews = reviewService.searchReviews(keyword);
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Flag a review as inappropriate")
    @PostMapping("/{id}/flag")
    public ResponseEntity<ReviewDTO> flagReview(@PathVariable Long id) {
        ReviewDTO flaggedReview = reviewService.flagReview(id);
        return ResponseEntity.ok(flaggedReview);
    }

    @Operation(summary = "Approve a flagged review")
    @PostMapping("/{id}/approve")
    public ResponseEntity<ReviewDTO> approveReview(@PathVariable Long id) {
        ReviewDTO approvedReview = reviewService.approveReview(id);
        return ResponseEntity.ok(approvedReview);
    }

    @Operation(summary = "Reject a flagged review")
    @PostMapping("/{id}/reject")
    public ResponseEntity<ReviewDTO> rejectReview(@PathVariable Long id) {
        ReviewDTO rejectedReview = reviewService.rejectReview(id);
        return ResponseEntity.ok(rejectedReview);
    }
}
