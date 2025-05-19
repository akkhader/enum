package com.khader.enums.controller;

import com.khader.enums.controller.response.Response;
import com.khader.enums.service.LookupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/lookups")
@RequiredArgsConstructor
@Tag(name = "LookupsController", description = "Lookup's API")
public class LookupController {

    private final LookupService lookupService;

    @Operation(summary = "Get common enumeration values", description = "ProviderStatus, WeightUnit, ParcelType, UserStatus", parameters = {@Parameter(name = "lookupType", required = true)})
    @GetMapping("/{lookupType}")
    public Response<?> getLookups(@PathVariable("lookupType") String lookupType) {
        return Response.builder().success(lookupService.getEnumValues(lookupType)).build();
    }


}
