package com.khader.enums.enums;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public enum PLRequestStatus implements LookupLabelProvider {

    CREATED_BY_CONSIGNEE(101, "Created by Consignee"),
    CREATED_BY_SYSTEM(102, "Created by System"),
    CREATED_BY_CS(103, "Created by CS"),

    ASSIGNED_TO_COURIER(104, "Assigned to courier"),

    PENDING_FROM_CONSIGNEE(11,"Waiting for the consignee to pick up the delivery point"),
    CONFIRMED_BY_CONSIGNEE(40, "Delivery point confirmed by Consignee"),

    CANCELLED(50, "Cancelled"),
    RETURNED_TO_WAREHOUSE(95,"Order returned to delivery point"),

    PLACED_IN_PARCEL_LOCKER_BY_COURIER(100, "Placed in Parcel Locker by Courier"),
    READY_FOR_RECEIVING(110, "Order is ready to be received by consignee"),

    // will not be placed by consignee as revoke  delivery will be applied throw ajex only
    PLACED_IN_PARCEL_LOCKER_BY_CONSIGNEE(401, "Placed in Parcel Locker by Consignee"),


    COLLECTED_SUCCESSFULLY(500, "Collected successfully"), //197
    REMOVED_SUCCESSFULLY(501, "Removed successfully"),

    REVOKE(140, "REVOKE"),
    EXPIRED(106, "Expired"),

    EXCEPTION_BY_PROVIDER(200, "Exception by Provider"),
    EXCEPTION_BY_COURIER(801, "Exception by Courier");

    private final Integer eventCode;
    private final String eventDescription;

    PLRequestStatus(Integer eventCode, String eventDescription) {
        this.eventCode = eventCode;
        this.eventDescription = eventDescription;
    }

    @Override
    public String getLabel() {
        return eventDescription;
    }

    @Override
    public String getValue() {
        return name();
    }

    public static PLRequestStatus fromLabel(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (PLRequestStatus type : values()) {
            if (type.getLabel().equalsIgnoreCase(value) || type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

    public static PLRequestStatus fromEventCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PLRequestStatus status : values()) {
            if (status.eventCode.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No  found for event code: " + code);
    }
}
