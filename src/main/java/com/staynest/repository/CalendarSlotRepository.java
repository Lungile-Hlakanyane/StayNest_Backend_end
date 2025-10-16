package com.staynest.repository;
import com.staynest.entity.CalendarSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CalendarSlotRepository extends JpaRepository<CalendarSlot, Long> {
    List<CalendarSlot> findByPropertyId(Long propertyId);
    List<CalendarSlot> findByBookedById(Long bookedById);
    List<CalendarSlot> findByLandlordIdAndStatus(Long landlordId, String status);
    long countByLandlord_Id(Long landlordId);
    long countByStatusIgnoreCase(String status);
    List<CalendarSlot> findByStatus(String status);
}
