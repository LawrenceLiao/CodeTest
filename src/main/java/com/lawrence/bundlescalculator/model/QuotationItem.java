package com.lawrence.bundlescalculator.model;

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
    private Map<SubmissionBundles, Integer> detailsOfBundles;

    public int getTotalNum(){
        int totalNum = 0;
        for(Map.Entry<SubmissionBundles,Integer> entry : detailsOfBundles.entrySet()){
           totalNum += entry.getKey().getNumPerBundle() * entry.getValue();
        }
        return totalNum;
    }

    public double getTotalPrice(){
        double totalPrice = 0.0;
        for(Map.Entry<SubmissionBundles,Integer> entry : detailsOfBundles.entrySet()){
            totalPrice += entry.getKey().getPriceOfBundle() * entry.getValue();
        }
        return totalPrice;
    }
}
