package com.niyaz.reviews_services.service;
import com.niyaz.reviews_services.config.ReviewMapper;
import com.niyaz.reviews_services.dto.ReviewCreateDTO;
import com.niyaz.reviews_services.dto.ReviewDTO;
import com.niyaz.reviews_services.dto.ReviewStatus;
import com.niyaz.reviews_services.dto.ReviewUpdateDTO;
import com.niyaz.reviews_services.entity.Review;
import com.niyaz.reviews_services.exception.ResourceNotFoundException;
import com.niyaz.reviews_services.repositoy.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    /**
     * Creates a new Review.
     *
     * @param reviewCreateDTO the DTO containing review creation data
     * @return the created ReviewDTO
     */
    public ReviewDTO createReview(ReviewCreateDTO reviewCreateDTO) {
        Review review = reviewMapper.toEntity(reviewCreateDTO);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDTO(savedReview);
    }

    /**
     * Retrieves a Review by its ID.
     *
     * @param id the ID of the Review
     * @return the corresponding ReviewDTO
     */
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        return reviewMapper.toDTO(review);
    }

    /**
     * Retrieves all Reviews.
     *
     * @return a list of ReviewDTOs
     */
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves Reviews by Company ID.
     *
     * @param companyId the Company ID
     * @return a list of ReviewDTOs
     */
    public List<ReviewDTO> getReviewsByCompanyId(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves Reviews by Job ID.
     *
     * @param jobId the Job ID
     * @return a list of ReviewDTOs
     */
    public List<ReviewDTO> getReviewsByJobId(Long jobId) {
        List<Review> reviews = reviewRepository.findByJobId(jobId);
        return reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing Review.
     *
     * @param id               the ID of the Review to update
     * @param reviewUpdateDTO the DTO containing update data
     * @return the updated ReviewDTO
     */
    public ReviewDTO updateReview(Long id, ReviewUpdateDTO reviewUpdateDTO) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        reviewMapper.updateEntity(existingReview, reviewUpdateDTO);
        Review updatedReview = reviewRepository.save(existingReview);
        return reviewMapper.toDTO(updatedReview);
    }

    /**
     * Deletes a Review by its ID.
     *
     * @param id the ID of the Review to delete
     */
    public void deleteReview(Long id) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        reviewRepository.delete(existingReview);
    }

    /**
     * Searches Reviews based on a keyword.
     *
     * @param keyword the search keyword
     * @return a list of matching ReviewDTOs
     */
    public List<ReviewDTO> searchReviews(String keyword) {
        List<Review> reviews = reviewRepository.findAll().stream()
                .filter(review -> review.getComment().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        return reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Flags a Review as inappropriate.
     *
     * @param id the ID of the Review to flag
     * @return the flagged ReviewDTO
     */
    public ReviewDTO flagReview(Long id) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        existingReview.setFlagged(true);
        Review flaggedReview = reviewRepository.save(existingReview);
        return reviewMapper.toDTO(flaggedReview);
    }

    /**
     * Approves a flagged Review.
     *
     * @param id the ID of the Review to approve
     * @return the approved ReviewDTO
     */
    public ReviewDTO approveReview(Long id) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        existingReview.setStatus(ReviewStatus.APPROVED);
        Review approvedReview = reviewRepository.save(existingReview);
        return reviewMapper.toDTO(approvedReview);
    }

    /**
     * Rejects a flagged Review.
     *
     * @param id the ID of the Review to reject
     * @return the rejected ReviewDTO
     */
    public ReviewDTO rejectReview(Long id) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));
        existingReview.setStatus(ReviewStatus.REJECTED);
        Review rejectedReview = reviewRepository.save(existingReview);
        return reviewMapper.toDTO(rejectedReview);
    }
}
