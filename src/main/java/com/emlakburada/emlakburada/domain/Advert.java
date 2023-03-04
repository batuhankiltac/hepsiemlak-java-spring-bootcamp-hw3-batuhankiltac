package com.emlakburada.emlakburada.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advert {

    private Integer userId;
    private RealEstate realEstate;
    private User user;
    private Integer advertNo;
    private String title;
    private Long price;
    private List<String> pictures;
    private Integer duration;
    private Boolean isPromotion = false;
    private Boolean isChecked = false;
    private Boolean isActive = false;
    private LocalDateTime creationDate;

    public Advert(RealEstate realEstate, User user, Integer advertNo, String title) {
        this.realEstate = realEstate;
        this.user = user;
        this.advertNo = advertNo;
        this.title = title;
    }
}