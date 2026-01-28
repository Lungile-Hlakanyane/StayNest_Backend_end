package com.staynest.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="calendar_slots")
public class CalendarSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate availableDate;
    private Integer maxGuests;
    private String bookingPolicy;
    @ManyToOne
    @JoinColumn(name = "booked_by_id")
    private User bookedBy;
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private User landlord;
    private String status = "available";
    private Boolean confirmed = false;
    private Boolean reject  = false;

    public CalendarSlot(Long id, LocalDate availableDate,
                        Integer maxGuests, String bookingPolicy,
                        Property property, User landlord,
                        String status,
                        User bookedBy,
                        Boolean confirmed,
                        Boolean reject
                        ) {
        this.id = id;
        this.availableDate = availableDate;
        this.maxGuests = maxGuests;
        this.bookingPolicy = bookingPolicy;
        this.property = property;
        this.landlord = landlord;
        this.status = status;
        this.bookedBy = bookedBy;
        this.confirmed = confirmed;
        this.reject = reject;
    }

    public CalendarSlot() {
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
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

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getReject() {
        return reject;
    }

    public void setReject(Boolean reject) {
        this.reject = reject;
    }
}
