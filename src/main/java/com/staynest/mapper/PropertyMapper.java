package com.staynest.mapper;
import com.staynest.DTO.PropertyDTO;
import com.staynest.entity.Property;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PropertyMapper {
    public Property toEntity(PropertyDTO dto) {
        Property property = new Property();
        property.setName(dto.getName());
        property.setLocation(dto.getLocation());
        property.setPrice(dto.getPrice());
        property.setDescription(dto.getDescription());
        property.setEmail(dto.getEmail());
        property.setBlocked(dto.isBlocked());
        property.setPhoneNumber(dto.getPhoneNumber());
        property.setAmenities(dto.getAmenities());
        property.setUserId(dto.getUserId());
        try {
            if (dto.getImage() != null && !dto.getImage().isEmpty()) {
                property.setImage(dto.getImage().getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read image", e);
        }

        return property;
    }
}
