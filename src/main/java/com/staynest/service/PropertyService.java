package com.staynest.service;
import com.staynest.DTO.PropertyDTO;
import com.staynest.entity.Property;
import java.util.List;

public interface PropertyService {
    void addProperty(PropertyDTO dto);
    List<Property> getAllProperties();
    long countPropertiesByUserId(Long userId);
    List<Property> getPropertiesByUserId(Long userId);
    boolean deleteProperty(Long propertyId);
    Property getPropertyById(Long id);
    boolean updateProperty(Long id, PropertyDTO dto);

}
