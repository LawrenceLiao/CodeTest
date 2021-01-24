package com.lawrence.bundlescalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Calculator {

    public static QuotationItem calculateBundles(OrderItem orderItem) {


        List<Integer> bundleType = MediaBundles.BUNDLE_LIST
                .stream()
                .filter(submissionBundles -> submissionBundles.getCodeOfMedia().equals(orderItem.getCodeOfMedia()))
                .map(submissionBundles -> submissionBundles.getNumPerBundle()).collect(Collectors.toList());

        ArrayList<Integer> bundleUsed = new ArrayList<>();
        for (int i = 0; i <= orderItem.getNumOfPost(); i++) {
            bundleUsed.add(0);
        }


        int numOfBundle = bundleType.size();

        Map<Integer, HashMap<Integer, Integer>> changeMap = new HashMap<>();

        for (int num = 1; num <= orderItem.getNumOfPost(); num++) {
            int minCount = num;
            HashMap<Integer, Integer> minBundleMap = new HashMap<>();

            for (int kind = 0; kind < numOfBundle; kind++) {

                int bundleValue = bundleType.get(kind);
                int gap = num - bundleValue;

                if (bundleValue <= num) {
                    int tmpCount = bundleUsed.get(gap) + 1;
                    if (tmpCount <= minCount) {

                        HashMap<Integer, Integer> subMap = changeMap.get(gap);
                        HashMap<Integer, Integer> tmpMap = new HashMap<>();
                        if (subMap != null) {
                            tmpMap.putAll(subMap);
                        }

                        if (tmpMap.containsKey(bundleValue)) {
                            tmpMap.put(bundleValue, subMap.get(bundleValue) + 1);
                        } else {
                            tmpMap.put(bundleValue, 1);
                        }
                        minCount = tmpCount;
                        minBundleMap = tmpMap;
                    }
                }
            }

            bundleUsed.set(num, minCount);
            changeMap.put(num, minBundleMap);


            if (num == orderItem.getNumOfPost()) {

                double totalPrice = 0.0;
                Map<SubmissionBundles, Integer> detailsOfBundles = new HashMap<>();

                for (Map.Entry<Integer, Integer> entry : minBundleMap.entrySet()) {

                    SubmissionBundles bundle = MediaBundles.BUNDLE_LIST
                            .stream()
                            .filter(submissionBundles -> submissionBundles.getCodeOfMedia().equals(orderItem.getCodeOfMedia()))
                            .filter(bundles -> bundles.getNumPerBundle() == entry.getKey()).findAny().get();
                    totalPrice += bundle.getPriceOfBundle() * entry.getValue();

                    detailsOfBundles.put(bundle, entry.getValue());
                }

                QuotationItem quotationItem = QuotationItem.builder().codeOfMedia(orderItem.getCodeOfMedia()).totalNumOfPost(orderItem.getNumOfPost()).totalPrice(totalPrice).detailsOfBundles(detailsOfBundles).build();
                return quotationItem;
            }

        }


        return null;

    }

}


