package com.lawrence.bundlescalculator.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBundles {
    private int numPerBundle;
    private double priceOfBundle;
}
