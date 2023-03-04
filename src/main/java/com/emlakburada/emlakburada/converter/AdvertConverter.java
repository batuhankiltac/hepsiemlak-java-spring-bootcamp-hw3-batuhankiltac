package com.emlakburada.emlakburada.converter;

import com.emlakburada.emlakburada.domain.Advert;
import com.emlakburada.emlakburada.helper.AdvertHelper;
import com.emlakburada.emlakburada.model.request.AdvertRequest;
import com.emlakburada.emlakburada.model.response.AdvertResponse;
import org.springframework.stereotype.Component;

@Component
public class AdvertConverter {

    public AdvertResponse convert(Advert advert) {
        return AdvertResponse.builder()
                .title(advert.getTitle())
                .price(advert.getPrice())
                .advertNo(advert.getAdvertNo())
                .build();
    }

    public Advert convert(AdvertRequest advertRequest) {
        return Advert.builder()
                .advertNo(AdvertHelper.advertNo++)
                .title(advertRequest.getTitle())
                .price(advertRequest.getPrice())
                .build();
    }
}
