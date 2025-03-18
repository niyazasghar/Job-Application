package com.niyaz.jobs_services.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private Long companyId;
    private String location;
    private JobType jobType;
    private int experienceLevel;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;
    private boolean isOpen;
}
