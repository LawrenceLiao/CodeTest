package com.lawrence.bundlescalculator;


import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Post {
    private String code;
    private int number;


    public abstract Map<Integer,Double > bundleTypes();

}
