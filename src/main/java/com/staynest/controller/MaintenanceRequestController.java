package com.staynest.controller;
import com.staynest.DTO.MaintenanceRequestDTO;
import com.staynest.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

    @Autowired
    private MaintenanceRequestService service;
    @PostMapping
    public MaintenanceRequestDTO createRequest(@RequestBody MaintenanceRequestDTO dto) {
        return service.createRequest(dto);
    }
    @GetMapping
    public List<MaintenanceRequestDTO> getAllRequests() {
        return service.getAllRequests();
    }
}
