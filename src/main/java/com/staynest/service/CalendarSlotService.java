package com.staynest.service;
import com.staynest.DTO.CalendarSlotDTO;
import com.staynest.entity.CalendarSlot;
import java.util.List;

public interface CalendarSlotService {
    void addCalendarSlots(CalendarSlotDTO dto);
    List<CalendarSlot> getSlotsByPropertyId(Long propertyId);
    boolean bookSlot(Long slotId, Long userId);
    List<CalendarSlotDTO> getSlotsByUserId(Long userId);
    long countSlotsByLandlordId(Long landlordId);
    long countAllBookedSlots();
    double calculateTotalEarnings();
    void confirmSlot(Long slotId);
    void rejectSlot(Long slotId);
    List<CalendarSlot> getSlotsByLandlordId(Long landlordId);
}
