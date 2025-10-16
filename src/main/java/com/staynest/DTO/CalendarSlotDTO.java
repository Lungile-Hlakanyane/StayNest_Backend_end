package com.staynest.DTO;
import com.staynest.entity.User;
import java.util.List;

public class CalendarSlotDTO {

    private Long id;
    private List<String> availabilityDates;
    private Integer maxGuests;
    private String bookingPolicy;
    private Long propertyId;
    private Long userId;
    private User bookedBy;
    private User landlord;
    private String status;
    public CalendarSlotDTO(List<String> availabilityDates,
                           Integer maxGuests, String bookingPolicy,
                           Long propertyId, Long userId,
                           User bookedBy,
                           Long id,
                           String status,
                           User landlord
                           ) {
        this.availabilityDates = availabilityDates;
        this.maxGuests = maxGuests;
        this.bookingPolicy = bookingPolicy;
        this.propertyId = propertyId;
        this.userId = userId;
        this.bookedBy = bookedBy;
        this.id = id;
        this.status = status;
        this.landlord = landlord;
    }

    public CalendarSlotDTO() {
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public List<String> getAvailabilityDates() {
        return availabilityDates;
    }

    public void setAvailabilityDates(List<String> availabilityDates) {
        this.availabilityDates = availabilityDates;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getBookingPolicy() {
        return bookingPolicy;
    }

    public void setBookingPolicy(String bookingPolicy) {
        this.bookingPolicy = bookingPolicy;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
