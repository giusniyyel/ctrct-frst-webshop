package com.giusniyyel.ctrctfrstwebshop.domain.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }
}
