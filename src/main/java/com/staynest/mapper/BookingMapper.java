package com.staynest.mapper;
import com.staynest.DTO.BookingDTO;
import com.staynest.entity.Booking;
import com.staynest.entity.CalendarSlot;
import com.staynest.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Base64;
@Component
public class BookingMapper {
    @Autowired
    private PropertyRepository propertyRepository;
    public BookingDTO toDto(CalendarSlot slot) {
        BookingDTO dto = new BookingDTO();
        dto.setId(slot.getId());
        dto.setAvailableDate(slot.getAvailableDate());
        dto.setBookingPolicy(slot.getBookingPolicy());
        dto.setMaxGuests(slot.getMaxGuests());
        dto.setStatus(slot.getStatus());

        if (slot.getLandlord() != null) {
            dto.setLandlordId(slot.getLandlord().getId());
        }

        if (slot.getProperty() != null) {
            dto.setPropertyId(slot.getProperty().getId());
        }

        if (slot.getBookedBy() != null) {
            dto.setBookedById(slot.getBookedBy().getId());
        }

        if (slot.getProperty() != null) {
            dto.setPropertyName(slot.getProperty().getName());
            dto.setPropertyLocation(slot.getProperty().getLocation());

            if (slot.getProperty().getImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(slot.getProperty().getImage());
                dto.setImageUrl("data:image/jpeg;base64," + base64Image);
            }
        }
        return dto;
    }

}
