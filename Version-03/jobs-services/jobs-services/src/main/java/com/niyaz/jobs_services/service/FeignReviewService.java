package com.niyaz.jobs_services.service;




import com.niyaz.jobs_services.dto.ReviewDTO;
import com.niyaz.jobs_services.service.client.ReviewsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;


@Service
public class FeignReviewService {
    @Autowired
    ReviewsFeignClient reviewsFeignClient;


    public List<ReviewDTO> fetchAllReviews(long jobId) {
        ResponseEntity<List<ReviewDTO>> listResponseEntity= reviewsFeignClient.getReviewsByCompanyId(jobId);
        return ReviewMapper(listResponseEntity);
    }
    public List<ReviewDTO> ReviewMapper(ResponseEntity<List<ReviewDTO>> listResponseEntity) {
        List<ReviewDTO> result = new ArrayList<>();

        if (listResponseEntity.getBody() != null) {
            for (ReviewDTO curr : listResponseEntity.getBody()) {
                result.add(new ReviewDTO(
                        curr.getId(),
                        curr.getUserId(),
                        curr.getCompanyId(),
                        curr.getJobId(),
                        curr.getRating(),
                        curr.getComment(),
                        curr.getStatus(),
                        curr.isFlagged(),
                        curr.getCreatedAt(),
                        curr.getUpdatedAt()
                ));
            }
        }
        return result;
    }

}
