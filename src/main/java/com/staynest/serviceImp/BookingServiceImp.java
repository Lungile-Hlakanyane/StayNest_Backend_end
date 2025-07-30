package com.staynest.serviceImp;
import com.staynest.DTO.BookingDTO;
import com.staynest.entity.Booking;
import com.staynest.entity.CalendarSlot;
import com.staynest.mapper.BookingMapper;
import com.staynest.repository.BookingRepository;
import com.staynest.repository.CalendarSlotRepository;
import com.staynest.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private CalendarSlotRepository calendarSlotRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Override
    public List<BookingDTO> findByLandlordId(Long landlordId) {
        List<CalendarSlot> slots = calendarSlotRepository.findByLandlordIdAndStatus(landlordId, "booked");
        return slots.stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
}
