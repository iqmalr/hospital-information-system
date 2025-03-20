package com.iqmalr.his.constant;

import lombok.Getter;

@Getter
public enum MaritalStatus {
    BELUM_KAWIN("Belum Kawin"),
    MENIKAH("Menikah"),
    CERAI("Cerai"),
    CERAI_MATI("Cerai Mati");

    private final String description;

    MaritalStatus(String description){
        this.description=description;
    }
}
