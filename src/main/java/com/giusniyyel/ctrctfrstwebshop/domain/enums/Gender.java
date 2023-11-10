package com.giusniyyel.ctrctfrstwebshop.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("male"),
    FEMALE("female"),
    UNISEX("unisex");

    private final String displayName;
}
