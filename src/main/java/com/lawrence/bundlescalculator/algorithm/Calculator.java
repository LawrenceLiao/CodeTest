package com.lawrence.bundlescalculator.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Calculator {

    public ComboOfBundles calculateBundles(ElementsOfCal elements) {


        ArrayList<Integer> bundleUsed = new ArrayList<>();
        for (int i = 0; i <= elements.getNumOfPost(); i++) {
            bundleUsed.add(0);
        }


        int numOfBundle = elements.getTypeOfBundles().size();

        Map<Integer, HashMap<Integer, Integer>> changeMap = new HashMap<>();

        for (int num = 1; num <= elements.getNumOfPost(); num++) {
            int minCount = num;
            HashMap<Integer, Integer> minBundleMap = new HashMap<>();

            for (int kind = 0; kind < numOfBundle; kind++) {

                int bundleValue = elements.getTypeOfBundles().get(kind);
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

            if (num == elements.getNumOfPost()) {
                ComboOfBundles comboOfBundles = ComboOfBundles.builder().numOfBundles(minBundleMap).build();
                return comboOfBundles;
            }

        }
        return null;
    }

}




