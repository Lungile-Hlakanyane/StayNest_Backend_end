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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private CalendarSlotRepository calendarSlotRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;
    @Override
    public List<BookingDTO> findByLandlordId(Long landlordId) {
        List<CalendarSlot> slots = calendarSlotRepository.findByLandlordIdAndStatus(landlordId, "booked");
        return slots.stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void approveBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setApproved(true);
            bookingRepository.save(booking);
        } else {
            System.out.println("Booking not found with id " + bookingId);
            throw new RuntimeException("Booking not found with id " + bookingId);
        }
    }
}
