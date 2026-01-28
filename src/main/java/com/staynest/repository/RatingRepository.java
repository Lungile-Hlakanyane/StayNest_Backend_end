package com.staynest.repository;
import com.staynest.entity.Property;
import com.staynest.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByProperty(Property property);
    List<Rating> findByUserId(Long userId);
}
