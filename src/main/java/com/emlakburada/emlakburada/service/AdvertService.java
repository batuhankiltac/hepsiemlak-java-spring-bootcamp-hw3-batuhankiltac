package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.client.BannerClient;
import com.emlakburada.emlakburada.config.EmailConfig;
import com.emlakburada.emlakburada.converter.AdvertConverter;
import com.emlakburada.emlakburada.domain.Advert;
import com.emlakburada.emlakburada.helper.AdvertHelper;
import com.emlakburada.emlakburada.model.request.AdvertRequest;
import com.emlakburada.emlakburada.model.request.BannerRequest;
import com.emlakburada.emlakburada.model.response.AdvertResponse;
import com.emlakburada.emlakburada.model.response.UserResponse;
import com.emlakburada.emlakburada.queue.QueueService;
import com.emlakburada.emlakburada.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final QueueService queueService;
    private final BannerClient bannerClient;
    private final AdvertConverter advertConverter;
    private final UserService userService;

    public AdvertResponse createAdvert(AdvertRequest advertRequest) {
        Advert advert = advertRepository.saveAdvert(advertConverter.convert(advertRequest));
        BannerRequest bannerRequest = new BannerRequest(AdvertHelper.advertNo);
        bannerClient.saveBanner(bannerRequest);
        EmailService emailService = new EmailService(new EmailConfig());
        queueService.sendMessage(emailService);
        return advertConverter.convert(advert);
    }

    public List<AdvertResponse> getAllAdverts() {
        return advertRepository.findAllAdverts().stream()
                .map(advertConverter::convert)
                .collect(Collectors.toList());
    }

    public AdvertResponse getAdvertByAdvertNo(Integer advertNo) {
        Advert advert = advertRepository.findAdvertByAdvertNo(advertNo);
        return advertConverter.convert(advert);
    }

    public Set<Advert> getFavoritesByUserId(Integer userId) {
        UserResponse userResponse = userService.getUserFavoritesById(userId);
        return userResponse.getFavorites();
    }
}