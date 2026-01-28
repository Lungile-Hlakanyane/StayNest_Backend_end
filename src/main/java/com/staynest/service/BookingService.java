package com.staynest.service;
import com.staynest.DTO.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> findByLandlordId(Long landlordId);
    void approveBooking(Long bookingId);
}
