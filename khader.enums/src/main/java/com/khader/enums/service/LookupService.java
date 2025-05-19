package com.khader.enums.service;


import com.khader.enums.controller.response.EnumResponse;
import com.khader.enums.enums.ParcelType;
import com.khader.enums.enums.ProviderStatus;
import com.khader.enums.enums.UserStatus;
import com.khader.enums.enums.WeightUnit;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LookupService {

    private final Map<String, List<EnumResponse>> enumValuesMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Class<?> enumClass : Arrays.asList(ProviderStatus.class, WeightUnit.class, ParcelType.class, UserStatus.class)) {
            if (enumClass.isEnum()) {
                Object[] enumConstants = enumClass.getEnumConstants();
                List<EnumResponse> enumResponses = Arrays.stream(enumConstants).map(enumConstant -> new EnumResponse((Enum<?>) enumConstant)).sorted(Comparator.comparing(EnumResponse::getKey)).collect(Collectors.toList());
                enumValuesMap.put(enumClass.getSimpleName(), enumResponses);
            }
        }
    }

    public List<EnumResponse> getEnumValues(String enumClassName) {
        return enumValuesMap.get(enumClassName);
    }


}
