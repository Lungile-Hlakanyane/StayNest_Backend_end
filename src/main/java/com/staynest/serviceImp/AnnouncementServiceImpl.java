package com.staynest.serviceImp;
import com.staynest.entity.Announcement;
import com.staynest.repository.AnnouncementRepository;
import com.staynest.service.AnnouncementService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
}
