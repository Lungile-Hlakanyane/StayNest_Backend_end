package com.staynest.mapper;
import com.staynest.DTO.RatingDTO;
import com.staynest.entity.Property;
import com.staynest.entity.Rating;
import com.staynest.entity.User;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public static RatingDTO toDTO(Rating rating) {
        RatingDTO dto = new RatingDTO();
        dto.setId(rating.getId());
        dto.setStars(rating.getStars());
        dto.setComment(rating.getComment());
        dto.setCreatedDate(rating.getCreatedDate());
        dto.setUserId(rating.getUser().getId());
        dto.setPropertyId(rating.getProperty().getId());
        return dto;
    }
    public static Rating toEntity(RatingDTO dto, User user, Property property) {
        Rating rating = new Rating();
        rating.setId(dto.getId());
        rating.setStars(dto.getStars());
        rating.setComment(dto.getComment());
        rating.setUser(user);
        rating.setProperty(property);
        rating.setCreatedDate(dto.getCreatedDate());
        return rating;
    }
}
