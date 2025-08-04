package com.staynest.service;
import com.staynest.DTO.MaintenanceRequestDTO;
import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequestDTO createRequest(MaintenanceRequestDTO dto);
    List<MaintenanceRequestDTO> getAllRequests();
}
