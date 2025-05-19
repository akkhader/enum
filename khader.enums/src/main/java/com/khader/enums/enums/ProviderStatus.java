package com.khader.enums.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum ProviderStatus implements LookupLabelProvider {
    ACTIVE("Active"),
    INACTIVE("Not Active");

    private final String label;

    ProviderStatus(String label) {
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

    public static ProviderStatus fromLabel(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (ProviderStatus type : values()) {
            if (type.getLabel().equalsIgnoreCase(value) || type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
