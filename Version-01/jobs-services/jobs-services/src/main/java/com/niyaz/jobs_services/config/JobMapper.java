package com.niyaz.jobs_services.config;


import com.niyaz.jobs_services.dto.JobCreateDTO;
import com.niyaz.jobs_services.dto.JobDTO;
import com.niyaz.jobs_services.dto.JobUpdateDTO;
import com.niyaz.jobs_services.entity.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

    /**
     * Maps JobCreateDTO to Job entity.
     *
     * @param dto the JobCreateDTO
     * @return the mapped Job entity
     */
    public Job toEntity(JobCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setCompanyId(dto.getCompanyId()); // Added mapping for companyId
        job.setLocation(dto.getLocation());
        job.setJobType(dto.getJobType());
        job.setExperienceLevel(dto.getExperienceLevel());
        return job;
    }

    /**
     * Maps Job entity to JobDTO.
     *
     * @param entity the Job entity
     * @return the mapped JobDTO
     */
    public JobDTO toDTO(Job entity) {
        if (entity == null) {
            return null;
        }

        JobDTO dto = new JobDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCompanyId(entity.getCompanyId());
        dto.setLocation(entity.getLocation());
        dto.setJobType(entity.getJobType());
        dto.setExperienceLevel(entity.getExperienceLevel());
        dto.setOpen(entity.isOpen());
        dto.setPostedAt(entity.getPostedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        // Add other field mappings as necessary

        return dto;
    }

    /**
     * Updates an existing Job entity with data from JobUpdateDTO.
     *
     * @param entity the existing Job entity
     * @param dto    the JobUpdateDTO
     */
    public void updateEntity(Job entity, JobUpdateDTO dto) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setLocation(dto.getLocation());
        entity.setJobType(dto.getJobType());
        entity.setExperienceLevel(dto.getExperienceLevel());
        entity.setOpen(dto.isOpen());
        // Add other field updates as necessary
    }
}
