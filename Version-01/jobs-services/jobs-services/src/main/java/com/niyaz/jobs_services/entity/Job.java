package com.niyaz.jobs_services.entity;


import com.niyaz.jobs_services.dto.JobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Job title is required")
    @Column(nullable = false)
    private String title;

    @Size(max = 1000, message = "Job description can be up to 1000 characters")
    private String description;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    @NotBlank(message = "Location is required")
    private String location;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Job type is required")
    private JobType jobType; // e.g., FULL_TIME, PART_TIME, CONTRACT

    @Min(value = 0, message = "Experience level cannot be negative")
    private int experienceLevel; // e.g., 1 for Junior, 2 for Mid, 3 for Senior

    @CreationTimestamp
    private LocalDateTime postedAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean isOpen = true;
}
