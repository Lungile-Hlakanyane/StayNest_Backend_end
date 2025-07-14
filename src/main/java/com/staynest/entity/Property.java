package com.staynest.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name ="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Double price;
    private String description;
    private String email;
    private String phoneNumber;
    @ElementCollection
    private List<String> amenities;
    @Lob
    private byte[] image;
    private Long userId;
    public Property(Long id,
                    String name, String location,
                    Double price, String description,
                    String email, String phoneNumber,
                    List<String> amenities, byte[] image,
                    Long userId
                    ) {
        this.id = id;
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
    public Property() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
