package com.staynest.mapper;
import com.staynest.DTO.MaintenanceRequestDTO;
import com.staynest.entity.MaintenanceRequest;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceRequestMapper {
    public static MaintenanceRequest toEntity(MaintenanceRequestDTO dto) {
        MaintenanceRequest request = new MaintenanceRequest();
        request.setTitle(dto.getTitle());
        request.setDescription(dto.getDescription());
        request.setPropertyName(dto.getPropertyName());
        request.setTenantName(dto.getTenantName());
        request.setDate(dto.getDate());
        return request;
    }

    public static MaintenanceRequestDTO toDTO(MaintenanceRequest entity) {
        MaintenanceRequestDTO dto = new MaintenanceRequestDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPropertyName(entity.getPropertyName());
        dto.setTenantName(entity.getTenantName());
        dto.setDate(entity.getDate());
        return dto;
    }
}
