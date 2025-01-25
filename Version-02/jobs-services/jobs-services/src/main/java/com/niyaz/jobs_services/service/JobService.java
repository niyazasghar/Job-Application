package com.niyaz.jobs_services.service;


import com.niyaz.jobs_services.config.JobMapper;
import com.niyaz.jobs_services.dto.JobCreateDTO;
import com.niyaz.jobs_services.dto.JobDTO;
import com.niyaz.jobs_services.dto.JobType;
import com.niyaz.jobs_services.dto.JobUpdateDTO;
import com.niyaz.jobs_services.entity.Job;
import com.niyaz.jobs_services.exception.ResourceNotFoundException;

import com.niyaz.jobs_services.repositoy.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapper jobMapper;

    /**
     * Creates a new Job.
     *
     * @param jobCreateDTO the DTO containing job creation data
     * @return the created JobDTO
     */
    public JobDTO createJob(JobCreateDTO jobCreateDTO) {
        // Validate company existence via Company Service (if applicable)

        Job job = jobMapper.toEntity(jobCreateDTO);
        Job savedJob = jobRepository.save(job);
        return jobMapper.toDTO(savedJob);
    }

    /**
     * Retrieves a Job by its ID.
     *
     * @param id the ID of the Job
     * @return the corresponding JobDTO
     */
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        return jobMapper.toDTO(job);
    }

    /**
     * Retrieves all Jobs.
     *
     * @return a list of JobDTOs
     */
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(jobMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves Jobs by Company ID.
     *
     * @param companyId the Company ID
     * @return a list of JobDTOs
     */
    public List<JobDTO> getJobsByCompanyId(Long companyId) {
        // Optionally validate company existence via Company Service

        List<Job> jobs = jobRepository.findByCompanyId(companyId);
        return jobs.stream()
                .map(jobMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing Job.
     *
     * @param id           the ID of the Job to update
     * @param jobUpdateDTO the DTO containing update data
     * @return the updated JobDTO
     */
    public JobDTO updateJob(Long id, JobUpdateDTO jobUpdateDTO) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        jobMapper.updateEntity(existingJob, jobUpdateDTO);
        Job updatedJob = jobRepository.save(existingJob);
        return jobMapper.toDTO(updatedJob);
    }

    /**
     * Deletes a Job by its ID.
     *
     * @param id the ID of the Job to delete
     */
    public void deleteJob(Long id) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        jobRepository.delete(existingJob);
    }

    /**
     * Searches Jobs based on title, job type, and location.
     *
     * @param title    the job title keyword
     * @param jobType  the type of job
     * @param location the job location
     * @return a list of matching JobDTOs
     */
    public List<JobDTO> searchJobs(String title, JobType jobType, String location) {
        // Implement search logic based on parameters
        // For simplicity, search by title only
        List<Job> jobs = jobRepository.findByTitleContainingIgnoreCase(title);
        return jobs.stream()
                .map(jobMapper::toDTO)
                .collect(Collectors.toList());
    }
}
