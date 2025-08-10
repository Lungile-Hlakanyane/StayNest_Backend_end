package com.staynest.service;
import com.staynest.DTO.ReportDTO;
import java.util.List;

public interface ReportService {
    void reportTenant(ReportDTO reportDTO);
    List<ReportDTO> getAllReports();
    void deleteReport(Long id);
}
