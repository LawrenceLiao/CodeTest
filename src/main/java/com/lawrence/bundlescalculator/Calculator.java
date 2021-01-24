package com.lawrence.bundlescalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Calculator {

    public static List<Bundle> calculateBundles(Post post) {

        List<Bundle> detailsOfBundles = new ArrayList<>();
        List<Integer> ListOfBundle = new ArrayList<>();
        List<Integer> bundleType = post.bundleTypes().keySet().stream().collect(Collectors.toList());

        ArrayList<Integer> bundleUsed = new ArrayList<>();
        for (int i = 0; i <= post.getNumber(); i++) {
            bundleUsed.add(0);
        }

        int numOfBundle = bundleType.size();

        Map<Integer, HashMap<Integer, Integer>> changeMap = new HashMap<>();

        for (int num = 1; num <= post.getNumber(); num++) {
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

            if (num == post.getNumber()) {
                for (Map.Entry<Integer, Integer> entry : minBundleMap.entrySet()) {
                    Bundle bundle = Bundle.builder()
                            .format(post.getClass().getSimpleName())
                            .code(post.getCode())
                            .numOfPosts(entry.getKey())
                            .price(post.bundleTypes().get(entry.getKey()))
                            .numOfBundles(entry.getValue()).build();


                    detailsOfBundles.add(bundle);
                }

            }

        }
        return detailsOfBundles;

    }

}


