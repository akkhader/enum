package com.khader.enums.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum ParcelType implements LookupLabelProvider {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

    private final String label;

    ParcelType(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return name();
    }

    public static ParcelType fromLabel(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (ParcelType type : values()) {
            if (type.getLabel().equalsIgnoreCase(value) || type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
