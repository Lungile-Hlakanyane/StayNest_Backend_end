package com.staynest.mapper;
import com.staynest.DTO.ReportDTO;
import com.staynest.entity.Report;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportMapper {
    public static Report toEntity(ReportDTO dto) {
        Report report = new Report();
        report.setLandlordId(dto.getLandlordId());
        report.setTenantId(dto.getTenantId());
        report.setReason(dto.getReason());
        report.setReportedAt(LocalDateTime.now());
        return report;
    }

    public ReportDTO toDTO(Report report) {
        ReportDTO dto = new ReportDTO();
        dto.setId(report.getId());
        dto.setLandlordId(report.getLandlordId());
        dto.setTenantId(report.getTenantId());
        dto.setReason(report.getReason());
        dto.setReportedAt(report.getReportedAt());
        return dto;
    }
}
