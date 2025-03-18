package com.niyaz.jobs_services.controller;

import com.niyaz.jobs_services.dto.*;
import com.niyaz.jobs_services.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Tag(name = "Jobs", description = "APIs for managing jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Operation(summary = "Create a new job")
    @PostMapping
    public ResponseEntity<JobDTO> createJob(@Validated @RequestBody JobCreateDTO jobCreateDTO) {
        JobDTO createdJob = jobService.createJob(jobCreateDTO);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a job by ID")
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getJobById(id);
        return ResponseEntity.ok(jobDTO);
    }

    @Operation(summary = "Get all jobs")
    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<JobDTO> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @Operation(summary = "Get jobs by Company ID")
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<JobDTO>> getJobsByCompanyId(@PathVariable Long companyId) {
        List<JobDTO> jobs = jobService.getJobsByCompanyId(companyId);
        return ResponseEntity.ok(jobs);
    }

    @Operation(summary = "Update a job by ID")
    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @Validated @RequestBody JobUpdateDTO jobUpdateDTO) {
        JobDTO updatedJob = jobService.updateJob(id, jobUpdateDTO);
        return ResponseEntity.ok(updatedJob);
    }

    @Operation(summary = "Delete a job by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search jobs")
    @GetMapping("/search")
    public ResponseEntity<List<JobDTO>> searchJobs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) JobType jobType,
            @RequestParam(required = false) String location) {
        List<JobDTO> jobs = jobService.searchJobs(title, jobType, location);
        return ResponseEntity.ok(jobs);
    }





}
