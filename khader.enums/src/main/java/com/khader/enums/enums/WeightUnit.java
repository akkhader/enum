package com.khader.enums.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum WeightUnit implements LookupLabelProvider {

    GRAM(0, "gram"), KG(1, "kg"), POUNDS(2, "pounds"), TONS(3, "tons");

    private final int value;

    private final String label;

    WeightUnit(final int newValue, final String newLabel) {
        value = newValue;
        label = newLabel;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public static WeightUnit fromLabel(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (WeightUnit type : WeightUnit.values()) {
            if (type.label.equalsIgnoreCase(value) || type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
    
    private static Map<Integer, WeightUnit> weightUnitByValue;

	public static WeightUnit findByValue(int value) {
		if (weightUnitByValue == null) {
			weightUnitByValue = Stream.of(WeightUnit.values())
					.collect(Collectors.toMap((e) -> (int) e.getValue(), Function.identity()));
		}

		return weightUnitByValue.get(value);

	}
}
