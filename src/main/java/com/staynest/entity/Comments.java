package com.staynest.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long propertyId;
    @Column(columnDefinition = "TEXT")
    private String comment;
    private LocalDateTime dateTime;
    private Long userId;
    public Comments() {
    }
    public Comments(Long id, Long propertyId, String comment, LocalDateTime dateTime, Long userId) {
        this.id = id;
        this.propertyId = propertyId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
