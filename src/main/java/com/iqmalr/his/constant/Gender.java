package com.iqmalr.his.constant;

import lombok.Getter;

@Getter

public enum Gender {
    L("Laki-Laki"),
    P("Perempuan");

    private final String description;
    Gender(String description){
        this.description=description;
    }
}
