package com.emlakburada.emlakburada.controller;

import com.emlakburada.emlakburada.domain.Advert;
import com.emlakburada.emlakburada.model.request.AdvertRequest;
import com.emlakburada.emlakburada.model.response.AdvertResponse;
import com.emlakburada.emlakburada.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/adverts")
public class AdvertController {
    private final AdvertService advertService;

    @PostMapping
    public AdvertResponse createAdvert(@RequestBody AdvertRequest request) {
        return advertService.createAdvert(request);
    }

    @GetMapping
    public List<AdvertResponse> getAllAdverts() {
        return advertService.getAllAdverts();
    }

    @GetMapping(value = "/{advertNo}")
    public AdvertResponse getAdvertByAdvertNo(@PathVariable Integer advertNo) {
        return advertService.getAdvertByAdvertNo(advertNo);
    }

    @GetMapping(value = "/favorites/{userId}")
    public Set<Advert> getFavoritesByUserId(@PathVariable Integer userId) {
        return advertService.getFavoritesByUserId(userId);
    }
}