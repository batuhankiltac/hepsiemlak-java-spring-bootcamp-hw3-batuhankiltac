package com.emlakburada.emlakburada.model.response;

import com.emlakburada.emlakburada.model.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {

    private Integer advertNo;
    private String phone;
    private Integer total;
    private AddressRequest address;
}