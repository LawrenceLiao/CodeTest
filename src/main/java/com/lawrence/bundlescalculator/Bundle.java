package com.lawrence.bundlescalculator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Bundle {

    private String format;
    private String code;
    private int numOfPosts;
    private double price;
    private int numOfBundles;

}

