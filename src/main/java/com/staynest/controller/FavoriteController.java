package com.staynest.controller;
import com.staynest.entity.Favorite;
import com.staynest.entity.Property;
import com.staynest.service.PropertyService;
import com.staynest.serviceImp.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final PropertyService propertyService;
    public FavoriteController(FavoriteService favoriteService, PropertyService propertyService) {
        this.favoriteService = favoriteService;
        this.propertyService = propertyService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestParam Long userId, @RequestParam Long propertyId) {
        favoriteService.addFavorite(userId, propertyId);
        return ResponseEntity.ok("Added to favorites");
    }
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFavorite(@RequestParam Long userId, @RequestParam Long propertyId) {
        favoriteService.removeFavorite(userId, propertyId);
        return ResponseEntity.ok("Removed from favorites");
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Property>> getFavorites(@PathVariable Long userId) {
        List<Favorite> favorites = favoriteService.getFavoritesByUserId(userId);
        List<Property> properties = favorites.stream()
                .map(fav -> propertyService.getPropertyById(fav.getPropertyId()))
                .filter(p -> p != null)
                .collect(Collectors.toList());
        return ResponseEntity.ok(properties);
    }
}
