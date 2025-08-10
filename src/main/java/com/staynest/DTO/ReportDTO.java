package com.staynest.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReportDTO {
    private Long id;
    private Long landlordId;
    private Long tenantId;
    private String reason;
    private LocalDateTime reportedAt;
    public ReportDTO() {}

    public ReportDTO(Long landlordId, Long tenantId, String reason, Long id, LocalDateTime reportedAt) {
        this.landlordId = landlordId;
        this.tenantId = tenantId;
        this.reason = reason;
        this.id = id;
        this.reportedAt = reportedAt;
    }


    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
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
}
