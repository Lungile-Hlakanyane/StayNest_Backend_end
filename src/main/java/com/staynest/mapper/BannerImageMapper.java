package com.staynest.mapper;
import com.staynest.DTO.BannerImageDTO;
import com.staynest.entity.BannerImage;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class BannerImageMapper {
    public static BannerImage toEntity(BannerImageDTO dto) {
        BannerImage bannerImage = new BannerImage();
        bannerImage.setUserId(dto.getUserId());
        bannerImage.setImage(dto.getImage());
        bannerImage.setDateTime(LocalDateTime.now());
        return bannerImage;
    }

    public BannerImageDTO toDTO(BannerImage bannerImage) {
        BannerImageDTO dto = new BannerImageDTO();
        dto.setId(bannerImage.getId());
        dto.setUserId(bannerImage.getUserId());
        dto.setImage(bannerImage.getImage());
        dto.setDateTime(bannerImage.getDateTime());
        return dto;
    }
}
