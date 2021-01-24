package com.lawrence.bundlescalculator;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionBundles {
    private String codeOfMedia;
    private int numPerBundle;
    private double priceOfBundle;
}
