package com.staynest.DTO;

public class BankCardRequest {
    private Long landlordId;
    private String cardholder;
    private String cardNumber;
    private String expiry;
    private String cvv;
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
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
