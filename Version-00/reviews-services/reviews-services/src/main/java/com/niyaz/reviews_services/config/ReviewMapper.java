package com.niyaz.reviews_services.config;



import com.niyaz.reviews_services.dto.ReviewCreateDTO;
import com.niyaz.reviews_services.dto.ReviewDTO;
import com.niyaz.reviews_services.dto.ReviewUpdateDTO;
import com.niyaz.reviews_services.entity.Review;
import com.niyaz.reviews_services.dto.ReviewStatus;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    /**
     * Maps ReviewCreateDTO to Review entity.
     *
     * @param dto the ReviewCreateDTO
     * @return the mapped Review entity
     */
    public Review toEntity(ReviewCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        Review review = new Review();
        review.setUserId(dto.getUserId());
        review.setCompanyId(dto.getCompanyId());
        review.setJobId(dto.getJobId());
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setStatus(ReviewStatus.PENDING); // Default status
        review.setFlagged(false); // Default flagged status

        return review;
    }

    /**
     * Maps Review entity to ReviewDTO.
     *
     * @param entity the Review entity
     * @return the mapped ReviewDTO
     */
    public ReviewDTO toDTO(Review entity) {
        if (entity == null) {
            return null;
        }

        ReviewDTO dto = new ReviewDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setCompanyId(entity.getCompanyId());
        dto.setJobId(entity.getJobId());
        dto.setRating(entity.getRating());
        dto.setComment(entity.getComment());
        dto.setStatus(entity.getStatus());
        dto.setFlagged(entity.isFlagged());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    /**
     * Updates an existing Review entity with data from ReviewUpdateDTO.
     *
     * @param entity the existing Review entity
     * @param dto    the ReviewUpdateDTO
     */
    public void updateEntity(Review entity, ReviewUpdateDTO dto) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setRating(dto.getRating());
        entity.setComment(dto.getComment());
        entity.setStatus(dto.getStatus());
        entity.setFlagged(dto.isFlagged());
        // Note: Do not update userId, companyId, or jobId unless necessary
    }
}

