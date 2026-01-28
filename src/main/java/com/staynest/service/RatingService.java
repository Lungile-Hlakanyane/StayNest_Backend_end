package com.staynest.service;
import com.staynest.DTO.RatingDTO;
import java.util.List;

public interface RatingService {
    RatingDTO createRating(RatingDTO ratingDTO);
    List<RatingDTO> getRatingsByProperty(Long propertyId);
    List<RatingDTO> getRatingsByUser(Long userId);
}
