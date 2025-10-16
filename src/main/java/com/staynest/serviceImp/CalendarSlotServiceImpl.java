package com.staynest.serviceImp;
import com.staynest.DTO.CalendarSlotDTO;
import com.staynest.entity.CalendarSlot;
import com.staynest.entity.Property;
import com.staynest.entity.User;
import com.staynest.mapper.CalendarSlotMapper;
import com.staynest.repository.CalendarSlotRepository;
import com.staynest.repository.PropertyRepository;
import com.staynest.repository.UserRepository;
import com.staynest.service.CalendarSlotService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarSlotServiceImpl implements CalendarSlotService {

    private final CalendarSlotRepository calendarSlotRepository;
    private final CalendarSlotMapper calendarSlotMapper;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public CalendarSlotServiceImpl(
            CalendarSlotRepository calendarSlotRepository,
            CalendarSlotMapper calendarSlotMapper, PropertyRepository propertyRepository,
            UserRepository userRepository) {
        this.calendarSlotRepository = calendarSlotRepository;
        this.calendarSlotMapper = calendarSlotMapper;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addCalendarSlots(CalendarSlotDTO dto) {
        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));
        User landlord = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Landlord (user) not found"));
        var slots = calendarSlotMapper.toEntities(dto, property, landlord);
        calendarSlotRepository.saveAll(slots);
    }
    @Override
    public List<CalendarSlot> getSlotsByPropertyId(Long propertyId) {
        return calendarSlotRepository.findByPropertyId(propertyId);
    }
    @Override
    public boolean bookSlot(Long slotId, Long userId) {
        CalendarSlot slot = calendarSlotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        if (!"available".equalsIgnoreCase(slot.getStatus())) {
            return false;
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        slot.setStatus("booked");
        slot.setBookedBy(user);
        calendarSlotRepository.save(slot);
        return true;
    }
    @Override
    public List<CalendarSlotDTO> getSlotsByUserId(Long userId) {
        List<CalendarSlot> slots = calendarSlotRepository.findByBookedById(userId);
        return slots.stream().map(calendarSlotMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public long countSlotsByLandlordId(Long landlordId) {
        return calendarSlotRepository.countByLandlord_Id(landlordId);
    }
    @Override
    public long countAllBookedSlots() {
        return calendarSlotRepository.countByStatusIgnoreCase("booked");
    }

    @Override
    public double calculateTotalEarnings() {
        List<CalendarSlot> bookedSlots = calendarSlotRepository.findByStatus("booked");
        return bookedSlots.stream()
                .filter(slot -> slot.getProperty() != null)
                .mapToDouble(slot -> slot.getProperty().getPrice())
                .sum();
    }
}
