package com.staynest.controller;
import com.staynest.DTO.MaintenanceRequestDTO;
import com.staynest.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
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
    @PatchMapping("/{id}/status")
    public MaintenanceRequestDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
    @GetMapping("/count/{userId}")
    public long countRequestsByUserId(@PathVariable Long userId) {
        return service.countRequestsByUserId(userId);
    }
}
