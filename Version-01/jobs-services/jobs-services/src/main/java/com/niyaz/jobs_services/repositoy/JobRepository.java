package com.niyaz.jobs_services.repositoy;

import com.niyaz.jobs_services.entity.Job;
import com.niyaz.jobs_services.dto.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyId(Long companyId);

    // Enhanced search methods
    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByJobType(JobType jobType);

    List<Job> findByLocationContainingIgnoreCase(String location);

}

