package com.giusniyyel.ctrctfrstwebshop.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Converter(autoApply = true)
@Slf4j
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if (gender == null) {
            return null;
        }
        log.debug("Converting to database column from: {} to: {}", gender, gender.getDisplayName());
        return gender.getDisplayName();
    }

    @Override
    public Gender convertToEntityAttribute(String displayName) {
        if (displayName == null) {
            return null;
        }
        for (Gender gender : Gender.values()) {
            if (gender.getDisplayName().equals(displayName)) {
                log.debug("Converting to entity attribute from: {} to: {}", displayName, gender);
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown gender: " + displayName);
    }
}
