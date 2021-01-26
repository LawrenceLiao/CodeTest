package com.lawrence.bundlescalculator.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ElementsOfCal {
    private int numOfPost;
    private List<Integer> typeOfBundles;
}
