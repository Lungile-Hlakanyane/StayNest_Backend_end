package com.staynest.serviceImp;
import com.staynest.DTO.BannerImageDTO;
import com.staynest.entity.BannerImage;
import com.staynest.mapper.BannerImageMapper;
import com.staynest.repository.BannerImageRepository;
import com.staynest.service.BannerImageService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BannerImageServiceImpl implements BannerImageService {
    private final BannerImageRepository bannerImageRepository;
    private final BannerImageMapper bannerImageMapper;

    public BannerImageServiceImpl(BannerImageRepository bannerImageRepository, BannerImageMapper bannerImageMapper) {
        this.bannerImageRepository = bannerImageRepository;
        this.bannerImageMapper = bannerImageMapper;
    }
    @Override
    public BannerImageDTO saveBannerImage(BannerImageDTO bannerImageDTO) {
        BannerImage bannerImage = BannerImageMapper.toEntity(bannerImageDTO);
        bannerImage = bannerImageRepository.save(bannerImage);
        return new BannerImageMapper().toDTO(bannerImage);
    }
    @Override
    public BannerImageDTO getBannerImageByUserId(Long userId) {
        Optional<BannerImage> bannerImageOptional = bannerImageRepository.findByUserId(userId);
        return bannerImageOptional.map(new BannerImageMapper()::toDTO).orElse(null);
    }
    @Override
    public void deleteBannerImage(Long id) {
        bannerImageRepository.deleteById(id);
    }
}
