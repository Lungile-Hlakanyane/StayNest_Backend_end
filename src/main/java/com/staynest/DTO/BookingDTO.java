package com.staynest.DTO;

import java.time.LocalDate;

public class BookingDTO {
    private Long id;
    private LocalDate availableDate;
    private String bookingPolicy;
    private int maxGuests;
    private String status;
    private Long landlordId;
    private Long propertyId;
    private Long bookedById;

    // Add property name, location, image if needed
    private String propertyName;
    private String propertyLocation;
    private String imageUrl;
    private Boolean approved = false;

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public String getBookingPolicy() {
        return bookingPolicy;
    }

    public void setBookingPolicy(String bookingPolicy) {
        this.bookingPolicy = bookingPolicy;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getBookedById() {
        return bookedById;
    }

    public void setBookedById(Long bookedById) {
        this.bookedById = bookedById;
    }
}
