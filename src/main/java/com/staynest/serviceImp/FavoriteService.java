package com.staynest.serviceImp;
import com.staynest.entity.Favorite;
import com.staynest.repository.FavoriteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    public void addFavorite(Long userId, Long propertyId) {
        if (!favoriteRepository.existsByUserIdAndPropertyId(userId, propertyId)) {
            Favorite fav = new Favorite(userId, propertyId);
            favoriteRepository.save(fav);
        }
    }
    @Transactional
    public void removeFavorite(Long userId, Long propertyId) {
        favoriteRepository.deleteByUserIdAndPropertyId(userId, propertyId);
    }
    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }
}
