package com.staynest.controller;
import com.staynest.entity.Announcement;
import com.staynest.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
    @PostMapping
    public ResponseEntity<Announcement> create(@RequestBody Announcement announcement) {
        Announcement saved = announcementService.createAnnouncement(announcement);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<Announcement>> getAll() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }
}
