package com.lawrence.bundlescalculator;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class Image extends Post {


    @Builder
    public Image(String code, int number) {
        super(code, number);
    }


    @Override
    public Map<Integer, Double> bundleTypes() {
        Map<Integer, Double> bundleTypes = new HashMap<Integer, Double>() {
            {
                put(5, 450.0);
                put(10, 800.0);
            }
        };
        return bundleTypes;
    }
}
