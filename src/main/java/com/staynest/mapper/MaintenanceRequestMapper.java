package com.staynest.mapper;
import com.staynest.DTO.MaintenanceRequestDTO;
import com.staynest.entity.MaintenanceRequest;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceRequestMapper {
    public static MaintenanceRequest toEntity(MaintenanceRequestDTO dto) {
        MaintenanceRequest request = new MaintenanceRequest();
        request.setId(dto.getId());
        request.setTitle(dto.getTitle());
        request.setDescription(dto.getDescription());
        request.setPropertyName(dto.getPropertyName());
        request.setTenantName(dto.getTenantName());
        request.setUserId(dto.getUserId());
        request.setDate(dto.getDate());
        request.setStatus(dto.getStatus());
        return request;
    }

    public static MaintenanceRequestDTO toDTO(MaintenanceRequest entity) {
        MaintenanceRequestDTO dto = new MaintenanceRequestDTO();
        dto.setTitle(entity.getTitle());
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setPropertyName(entity.getPropertyName());
        dto.setTenantName(entity.getTenantName());
        dto.setDate(entity.getDate());
        dto.setUserId(entity.getUserId());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
