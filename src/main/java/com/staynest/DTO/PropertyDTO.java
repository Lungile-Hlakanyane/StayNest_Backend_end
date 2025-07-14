package com.staynest.DTO;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public class PropertyDTO {
    private String name;
    private String location;
    private Double price;
    private String description;
    private String email;
    private String phoneNumber;
    private List<String> amenities;
    private MultipartFile image;

    private Long userId;
    public PropertyDTO() {
    }

    public PropertyDTO(String name,
                       String location,
                       Double price,
                       String description,
                       String email,
                       String phoneNumber,
                       List<String> amenities,
                       MultipartFile image,
                       Long userId
                       ) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.amenities = amenities;
        this.image = image;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
