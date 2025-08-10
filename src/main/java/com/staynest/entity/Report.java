package com.staynest.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tenant_reposts")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long landlordId;
    private Long tenantId;
    private String reason;
    private LocalDateTime reportedAt;
    public Report() {
    }
    public Report(Long id, Long landlordId, String reason, LocalDateTime reportedAt) {
        this.id = id;
        this.landlordId = landlordId;
        this.tenantId = tenantId;
        this.reason = reason;
        this.reportedAt = reportedAt;
    }

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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }
}
