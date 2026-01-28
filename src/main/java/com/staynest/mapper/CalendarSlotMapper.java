package com.staynest.mapper;
import com.staynest.DTO.CalendarSlotDTO;
import com.staynest.entity.CalendarSlot;
import com.staynest.entity.Property;
import com.staynest.entity.User;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CalendarSlotMapper {
    public List<CalendarSlot> toEntities(CalendarSlotDTO dto, Property property, User landlord) {
        return dto.getAvailabilityDates().stream()
                .map(dateStr -> {
                    CalendarSlot slot = new CalendarSlot();
                    slot.setAvailableDate(LocalDate.parse(dateStr));
                    slot.setMaxGuests(dto.getMaxGuests());
                    slot.setBookingPolicy(dto.getBookingPolicy());
                    slot.setProperty(property);
                    slot.setLandlord(landlord);
                    slot.setStatus("available");
                    slot.setConfirmed(dto.getConfirmed());
                    slot.setReject(dto.getReject());
                    return slot;
                })
                .collect(Collectors.toList());
    }

    public CalendarSlotDTO toDto(CalendarSlot slot) {
        CalendarSlotDTO dto = new CalendarSlotDTO();
        dto.setId(slot.getId());
        dto.setMaxGuests(slot.getMaxGuests());
        dto.setBookingPolicy(slot.getBookingPolicy());
        dto.setStatus(slot.getStatus());
        dto.setPropertyId(slot.getProperty().getId());
        dto.setAvailabilityDates(List.of(slot.getAvailableDate().toString()));
        dto.setConfirmed(slot.getConfirmed());
        dto.setReject(slot.getReject());
        return dto;
    }
}
