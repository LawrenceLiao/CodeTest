package com.lawrence.bundlescalculator;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class Video extends Post {


    @Builder
    public Video(String code, int number) {
        super(code, number);
    }

    @Override
    public Map<Integer, Double> bundleTypes() {
        Map<Integer, Double> bundleTypes = new HashMap<Integer, Double>() {
            {
                put(3, 570.0);
                put(5, 900.0);
                put(9, 1530.0);
            }
        };
        return bundleTypes;
    }
}
