package com.staynest.controller;
import com.staynest.DTO.BookingDTO;
import com.staynest.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/landlord/{landlordId}")
    public List<BookingDTO> getBookingsByLandlordId(@PathVariable Long landlordId) {
        return bookingService.findByLandlordId(landlordId);
    }

}
