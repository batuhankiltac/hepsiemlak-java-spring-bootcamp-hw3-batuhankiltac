package com.emlakburada.emlakburada.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertRequest {

    private String title;
    private Long price;
    private Integer duration;
    private Boolean isPromotion;
    private Boolean isChecked;
    private Boolean isActive;
}