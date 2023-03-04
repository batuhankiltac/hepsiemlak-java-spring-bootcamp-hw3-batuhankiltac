package com.emlakburada.emlakburada.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest {
    private Integer advertNo;
    private String phone;
    private Integer total;
    private AddressRequest address;

    public BannerRequest(Integer advertNo) {
        this.advertNo = advertNo;
    }
}