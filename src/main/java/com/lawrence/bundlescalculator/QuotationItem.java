package com.lawrence.bundlescalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuotationItem {
    private String codeOfMedia;
    private int totalNumOfPost;
    private double totalPrice;
    private Map<SubmissionBundles, Integer> detailsOfBundles;
}
