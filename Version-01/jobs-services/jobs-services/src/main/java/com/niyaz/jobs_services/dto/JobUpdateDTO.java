package com.niyaz.jobs_services.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class JobUpdateDTO {
    @NotBlank(message = "Job title is required")
    private String title;

    @Size(max = 1000, message = "Job description can be up to 1000 characters")
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Job type is required")
    private JobType jobType;

    @Min(value = 0, message = "Experience level cannot be negative")
    private int experienceLevel;

    private boolean isOpen;
}
