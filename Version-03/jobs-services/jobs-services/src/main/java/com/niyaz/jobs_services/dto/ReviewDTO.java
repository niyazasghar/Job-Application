package com.niyaz.jobs_services.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Long companyId;
    private Long jobId;
    private int rating;
    private String comment;
    private ReviewStatus status;
    private boolean isFlagged;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
