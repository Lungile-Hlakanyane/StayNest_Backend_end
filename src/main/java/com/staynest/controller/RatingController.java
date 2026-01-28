package com.staynest.controller;
import com.staynest.DTO.RatingDTO;
import com.staynest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public RatingDTO createRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.createRating(ratingDTO);
    }
    @GetMapping("/property/{propertyId}")
    public List<RatingDTO> getRatingsByProperty(@PathVariable Long propertyId) {
        return ratingService.getRatingsByProperty(propertyId);
    }
    @GetMapping("/user/{userId}")
    public List<RatingDTO> getRatingsByUser(@PathVariable Long userId) {
        return ratingService.getRatingsByUser(userId);
    }
}
