package com.khader.enums.controller.response;

import com.khader.enums.enums.LookupLabelProvider;
import lombok.Getter;

@Getter
public  class EnumResponse {
    private final Object value;
    private final String key;
    private final String label;

    public EnumResponse(Enum<?> enumConstant) {
        this.key = enumConstant.name();
        this.label = ((LookupLabelProvider) enumConstant).getLabel();
        this.value = ((LookupLabelProvider) enumConstant).getValue();
    }

}
