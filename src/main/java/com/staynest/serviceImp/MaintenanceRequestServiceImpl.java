package com.staynest.serviceImp;
import com.staynest.DTO.MaintenanceRequestDTO;
import com.staynest.entity.MaintenanceRequest;
import com.staynest.mapper.MaintenanceRequestMapper;
import com.staynest.repository.MaintenanceRequestRepository;
import com.staynest.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {

    @Autowired
    private MaintenanceRequestRepository repository;

    @Override
    public MaintenanceRequestDTO createRequest(MaintenanceRequestDTO dto) {
        MaintenanceRequest saved = repository.save(MaintenanceRequestMapper.toEntity(dto));
        return MaintenanceRequestMapper.toDTO(saved);
    }
    @Override
    public List<MaintenanceRequestDTO> getAllRequests() {
        return repository.findAll()
                .stream()
                .map(MaintenanceRequestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
