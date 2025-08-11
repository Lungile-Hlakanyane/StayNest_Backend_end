package com.staynest.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "bank_cards")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long landlordId; // FK to your landlord/user table
    private String cardholder;
    private String last4Digits; // store this separately for display
    private String cardNumberHash;
    private String cvvHash;
    private String expiry;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getLandlordId() {
        return landlordId;
    }
    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }
    public String getCardholder() {
        return cardholder;
    }
    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }
    public String getLast4Digits() {
        return last4Digits;
    }
    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }
    public String getCardNumberHash() {
        return cardNumberHash;
    }
    public void setCardNumberHash(String cardNumberHash) {
        this.cardNumberHash = cardNumberHash;
    }
    public String getCvvHash() {
        return cvvHash;
    }
    public void setCvvHash(String cvvHash) {
        this.cvvHash = cvvHash;
    }
    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
