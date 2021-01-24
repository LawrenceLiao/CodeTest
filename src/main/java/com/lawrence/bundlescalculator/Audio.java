package com.lawrence.bundlescalculator;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class Audio extends Post {

    @Builder
    public Audio(String code, int number) {
        super(code, number);
    }

    @Override
    public Map<Integer, Double> bundleTypes() {
        Map<Integer, Double> bundleTypes = new HashMap<Integer, Double>() {
            {
                put(3, 427.7);
                put(6, 810.0);
                put(9, 1147.5);
            }
        };
        return bundleTypes;
    }
}
