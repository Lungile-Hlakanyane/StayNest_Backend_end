package com.staynest.serviceImp;
import com.staynest.DTO.PropertyDTO;
import com.staynest.entity.Property;
import com.staynest.mapper.PropertyMapper;
import com.staynest.repository.PropertyRepository;
import com.staynest.service.PropertyService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImp implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;
    public PropertyServiceImp(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }
    @Override
    public void addProperty(PropertyDTO dto) {
        Property property = propertyMapper.toEntity(dto);
        propertyRepository.save(property);
    }
    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
    @Override
    public long countPropertiesByUserId(Long userId) {
        return propertyRepository.countByUserId(userId);
    }
    @Override
    public List<Property> getPropertiesByUserId(Long userId) {
        return propertyRepository.findByUserId(userId);
    }

    @Override
    public boolean deleteProperty(Long propertyId) {
        if (propertyRepository.existsById(propertyId)) {
            propertyRepository.deleteById(propertyId);
            return true;
        }
        return false;
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateProperty(Long id, PropertyDTO dto) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (optionalProperty.isPresent()) {
            Property property = optionalProperty.get();
            property.setName(dto.getName());
            property.setLocation(dto.getLocation());
            property.setPrice(dto.getPrice());
            property.setPhoneNumber(dto.getPhoneNumber());
            property.setEmail(dto.getEmail());
            property.setDescription(dto.getDescription());
            property.setAmenities(dto.getAmenities());
            if (dto.getImage() != null) {
                try {
                    property.setImage(Base64.getEncoder().encodeToString(dto.getImage().getBytes()).getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to encode image", e);
                }
            }
            propertyRepository.save(property);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long countAllProperties() {
        return propertyRepository.count();
    }
}
