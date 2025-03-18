package com.niyaz.jobs_services.entity;



import com.niyaz.jobs_services.dto.ApplicationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Job ID is required")
    private Long jobId;

    @NotNull(message = "First Name  is required")
    private String firstName;

    @NotNull(message = "last Name  is required")
    private String lastName;

    @NotNull(message = "Resume is Required")
    private String resumeLink;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Application status is required")
    private ApplicationStatus status; // e.g., APPLIED, INTERVIEW, OFFERED, REJECTED

    @CreationTimestamp
    private LocalDateTime appliedAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
