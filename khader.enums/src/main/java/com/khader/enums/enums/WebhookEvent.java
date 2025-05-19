package com.khader.enums.enums;

import lombok.Getter;

@Getter
public enum WebhookEvent {

    ORDER_CREATE("order.create"),
    ORDER_UPDATE("order.update"),
    ORDER_CHANGE_STATUS("order.change_status");

    private final String value;

    WebhookEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WebhookEvent fromValue(String value) {
        for (WebhookEvent type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown webhook type: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
