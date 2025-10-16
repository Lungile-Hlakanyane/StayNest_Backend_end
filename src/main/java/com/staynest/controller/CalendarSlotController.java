package com.staynest.controller;
import com.staynest.DTO.CalendarSlotDTO;
import com.staynest.DTO.SlotBookingRequest;
import com.staynest.entity.CalendarSlot;
import com.staynest.repository.CalendarSlotRepository;
import com.staynest.service.CalendarSlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calendar-slots")
public class CalendarSlotController {

    private final CalendarSlotRepository calendarSlotRepository;
    private final CalendarSlotService calendarSlotService;
    public CalendarSlotController(CalendarSlotRepository calendarSlotRepository, CalendarSlotService calendarSlotService) {
        this.calendarSlotRepository = calendarSlotRepository;
        this.calendarSlotService = calendarSlotService;
    }
    @PostMapping
    public ResponseEntity<String> addCalendar(@RequestBody CalendarSlotDTO dto) {
        calendarSlotService.addCalendarSlots(dto);
        return ResponseEntity.ok("Calendar slots added successfully");
    }
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<CalendarSlot>> getSlotsByProperty(@PathVariable Long propertyId) {
        List<CalendarSlot> slots = calendarSlotService.getSlotsByPropertyId(propertyId);
        return ResponseEntity.ok(slots);
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookSlot(@RequestBody SlotBookingRequest request) {
        boolean success = calendarSlotService.bookSlot(request.getSlotId(), request.getUserId());
        if (success) {
            return ResponseEntity.ok("Slot booked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to book the slot.");
        }
    }
    @GetMapping("/slots/user/{userId}")
    public List<CalendarSlotDTO> getSlotsByUserId(@PathVariable Long userId) {
        return calendarSlotService.getSlotsByUserId(userId);
    }
    @GetMapping("/count/landlord/{landlordId}")
    public ResponseEntity<Long> countSlotsByLandlord(@PathVariable Long landlordId) {
        long count = calendarSlotService.countSlotsByLandlordId(landlordId);
        return ResponseEntity.ok(count);
    }
    @GetMapping("/count/booked")
    public ResponseEntity<Long> countAllBookedSlots() {
        long count = calendarSlotService.countAllBookedSlots();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/earnings/total")
    public ResponseEntity<Double> getTotalEarnings() {
        double totalEarnings = calendarSlotService.calculateTotalEarnings();
        return ResponseEntity.ok(totalEarnings);
    }

    @GetMapping("/status/booked")
    public List<CalendarSlot> getBookedSlots() {
        return calendarSlotRepository.findByStatus("booked");
    }

}
