package com.emlakburada.emlakburada.model.response;

import com.emlakburada.emlakburada.domain.RealEstate;
import com.emlakburada.emlakburada.domain.User;
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
public class AdvertResponse {

    private RealEstate realEstate;
    private User user;
    private Integer advertNo;
    private String title;
    private Long price;
    private List<String> pictures;
    private Integer duration;
    private Boolean isPromotion;
    private Boolean isChecked;
    private Boolean isActive;
    private LocalDateTime creationDate;
}