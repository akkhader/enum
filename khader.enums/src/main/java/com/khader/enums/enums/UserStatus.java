package com.khader.enums.enums;

import com.ajex.core.web.enums.LookupLabelProvider;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum UserStatus implements LookupLabelProvider {
    ACTIVE("Active"),
    INACTIVE("Not Active");

    private final String label;

    UserStatus(String label) {
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

    public static UserStatus fromLabel(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (UserStatus type : values()) {
            if (type.getLabel().equalsIgnoreCase(value) || type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
