package com.staynest.controller;
import com.staynest.DTO.PropertyDTO;
import com.staynest.entity.CalendarSlot;
import com.staynest.entity.Property;
import com.staynest.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    private final PropertyService propertyService;
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addProperty(
            @RequestPart("property") PropertyDTO dto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        dto.setImage(image);
        propertyService.addProperty(dto);
        return ResponseEntity.ok("Property added successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties(){
        return ResponseEntity.ok(propertyService.getAllProperties());
    }
    @GetMapping("/count/{userId}")
    public ResponseEntity<Long> countPropertiesByUserId(@PathVariable Long userId) {
        long count = propertyService.countPropertiesByUserId(userId);
        return ResponseEntity.ok(count);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Property>> getPropertiesByUserId(@PathVariable Long userId) {
        List<Property> properties = propertyService.getPropertiesByUserId(userId);
        return ResponseEntity.ok(properties);
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long propertyId) {
        boolean deleted = propertyService.deleteProperty(propertyId);
        if (deleted) {
            return ResponseEntity.ok("Property deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        if (property != null) {
            return ResponseEntity.ok(property);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProperty(
            @PathVariable Long id,
            @RequestPart("property") PropertyDTO dto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        dto.setImage(image);
        boolean updated = propertyService.updateProperty(id, dto);
        if (updated) {
            return ResponseEntity.ok("Property updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/count-all")
    public ResponseEntity<Long> countAllProperties() {
        long count = propertyService.countAllProperties();
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<String> blockProperty(@PathVariable Long id) {
        boolean result = propertyService.blockProperty(id);
        if (result) {
            return ResponseEntity.ok("Property blocked successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/unblock")
    public ResponseEntity<String> unblockProperty(@PathVariable Long id) {
        boolean result = propertyService.unblockProperty(id);
        if (result) {
            return ResponseEntity.ok("Property unblocked successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
