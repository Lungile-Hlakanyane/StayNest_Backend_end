package com.staynest.serviceImp;
import com.staynest.DTO.ReportDTO;
import com.staynest.entity.Report;
import com.staynest.mapper.ReportMapper;
import com.staynest.repository.ReportRepository;
import com.staynest.service.ReportService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImp implements ReportService {

    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;
    public ReportServiceImp(ReportMapper reportMapper, ReportRepository reportRepository) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
    }
    @Override
    public void reportTenant(ReportDTO reportDTO) {
        Report report = ReportMapper.toEntity(reportDTO);
        reportRepository.save(report);
    }
    @Override
    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(reportMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
