package com.staynest.service;
import com.staynest.entity.Announcement;
import java.util.List;

public interface AnnouncementService {
    Announcement createAnnouncement(Announcement announcement);
    List<Announcement> getAllAnnouncements();
}
