package com.staynest.serviceImp;
import com.staynest.DTO.RatingDTO;
import com.staynest.entity.Property;
import com.staynest.entity.Rating;
import com.staynest.entity.User;
import com.staynest.mapper.RatingMapper;
import com.staynest.repository.PropertyRepository;
import com.staynest.repository.RatingRepository;
import com.staynest.repository.UserRepository;
import com.staynest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImp implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Override
    public RatingDTO createRating(RatingDTO ratingDTO) {
        User user = userRepository.findById(ratingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Property property = propertyRepository.findById(ratingDTO.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));
        Rating rating = RatingMapper.toEntity(ratingDTO, user, property);
        Rating saved = ratingRepository.save(rating);
        return RatingMapper.toDTO(saved);
    }
    @Override
    public List<RatingDTO> getRatingsByProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        return ratingRepository.findByProperty(property)
                .stream()
                .map(RatingMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<RatingDTO> getRatingsByUser(Long userId) {
        return ratingRepository.findByUserId(userId)
                .stream()
                .map(RatingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
