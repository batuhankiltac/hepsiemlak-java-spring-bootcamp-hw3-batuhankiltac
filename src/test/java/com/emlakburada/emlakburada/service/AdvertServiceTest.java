package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.client.BannerClient;
import com.emlakburada.emlakburada.converter.AdvertConverter;
import com.emlakburada.emlakburada.domain.Advert;
import com.emlakburada.emlakburada.helper.AdvertHelper;
import com.emlakburada.emlakburada.model.request.AdvertRequest;
import com.emlakburada.emlakburada.model.response.UserResponse;
import com.emlakburada.emlakburada.queue.QueueService;
import com.emlakburada.emlakburada.repository.AdvertRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AdvertServiceTest {

    @InjectMocks
    private AdvertService advertService;

    @Mock
    private AdvertRepository advertRepository;

    @Mock
    private QueueService queueService;

    @Mock
    private BannerClient bannerClient;

    @Mock
    private AdvertConverter advertConverter;

    @Mock
    private UserService userService;

    @Test
    public void it_should_save_advert() {
        // Given
        AdvertRequest advertRequest = AdvertRequest.builder()
                .price(BigDecimal.TEN.longValue())
                .build();

        // When
        advertService.createAdvert(advertRequest);

        // Then
        assertThat(advertRequest.getPrice()).isEqualTo(BigDecimal.TEN.intValue());
    }

    @Test
    public void it_should_get_all_adverts() {
        // Given
        final Advert advert1 = Advert.builder()
                .title("test-title1")
                .price(1500L)
                .duration(30)
                .build();
        final Advert advert2 = Advert.builder()
                .title("test-title2")
                .price(3000L)
                .duration(60)
                .build();
        List<Advert> adverts = Arrays.asList(advert1, advert2);

        // When
        advertService.getAllAdverts();

        // Then
        verify(advertRepository).findAllAdverts();
        assertThat(advert1.getTitle()).isNotNull();
        assertThat(adverts.size()).isNotZero();
    }

    @Test
    public void it_should_get_advert_by_advert_no() {
        // Given
        final Integer advertNo = AdvertHelper.advertNo;
        final Advert advert = Advert.builder()
                .title("test-title1")
                .price(1500L)
                .duration(30)
                .build();
        when(advertRepository.findAdvertByAdvertNo(advertNo)).thenReturn(advert);

        // When
        advertService.getAdvertByAdvertNo(advertNo);

        // Then
        verify(advertRepository).findAdvertByAdvertNo(advertNo);
    }

    @Test
    public void it_should_get_favorites_by_user_id() {
        // Given
        final Integer userId = 1;
        UserResponse userResponse = UserResponse.builder().build();
        when(userService.getUserFavoritesById(userId)).thenReturn(userResponse);

        // When
        advertService.getFavoritesByUserId(userId);

        // Then
        verify(userService).getUserFavoritesById(userId);
    }
}