package com.staynest.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime expiryDate;

    public VerificationToken(Long id, String token, User user, LocalDateTime expiryDate) {
        this.id = id;
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public VerificationToken() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
