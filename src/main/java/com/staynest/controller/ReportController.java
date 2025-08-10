package com.staynest.controller;
import com.staynest.DTO.ReportDTO;
import com.staynest.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @PostMapping
    public ResponseEntity<String> reportTenant(@RequestBody ReportDTO reportDTO) {
        System.out.println("Incoming report: " + reportDTO.getLandlordId() + ", " + reportDTO.getTenantId() + ", " + reportDTO.getReason());
        reportService.reportTenant(reportDTO);
        return ResponseEntity.ok("Tenant reported successfully.");
    }
    @GetMapping
    public ResponseEntity<List<ReportDTO>> getAllReports() {
        List<ReportDTO> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok("Report deleted successfully.");
    }
}
