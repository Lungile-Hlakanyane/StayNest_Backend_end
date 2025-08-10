package com.staynest.DTO;
import java.time.LocalDateTime;

public class CommentDTO {
    private Long id;
    private Long propertyId;
    private String comment;
    private LocalDateTime dateTime;
    private Long userId;

    public CommentDTO() {
    }

    public CommentDTO(Long id, Long propertyId, String comment, LocalDateTime dateTime, Long userId) {
        this.id = id;
        this.propertyId = propertyId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
