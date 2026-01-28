package com.staynest.controller;
import com.staynest.DTO.BannerImageDTO;
import com.staynest.service.BannerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/banner-images")
public class BannerImageController {
    private final BannerImageService bannerImageService;
    @Autowired
    public BannerImageController(BannerImageService bannerImageService) {
        this.bannerImageService = bannerImageService;
    }

    @PostMapping
    public ResponseEntity<BannerImageDTO> saveBannerImage(
            @RequestParam("userId") Long userId,
            @RequestParam("image") MultipartFile image
    ) {
        BannerImageDTO bannerImageDTO = new BannerImageDTO();
        bannerImageDTO.setUserId(userId);
        try {
            bannerImageDTO.setImage(image.getBytes());
        } catch (IOException e) {
        }
        BannerImageDTO savedBannerImage = bannerImageService.saveBannerImage(bannerImageDTO);
        return ResponseEntity.ok(savedBannerImage);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BannerImageDTO> getBannerImageByUserId(@PathVariable Long userId) {
        BannerImageDTO bannerImage = bannerImageService.getBannerImageByUserId(userId);
        return ResponseEntity.ok(bannerImage);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBannerImage(@PathVariable Long id) {
        bannerImageService.deleteBannerImage(id);
        return ResponseEntity.noContent().build();
    }
}
