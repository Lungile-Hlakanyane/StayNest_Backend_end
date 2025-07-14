package com.staynest.repository;
import com.staynest.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    long countByUserId(Long userId);
    List<Property> findByUserId(Long userId);
}
