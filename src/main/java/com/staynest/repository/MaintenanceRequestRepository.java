package com.staynest.repository;
import com.staynest.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
}
