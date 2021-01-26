package com.lawrence.bundlescalculator.util;

import com.lawrence.bundlescalculator.algorithm.Calculator;
import com.lawrence.bundlescalculator.algorithm.ComboOfBundles;
import com.lawrence.bundlescalculator.algorithm.ElementsOfCal;
import com.lawrence.bundlescalculator.model.*;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@UtilityClass
public class DataHandler {

    public QuotationItem formQuotationItem(String codeOfMedia, ComboOfBundles comboOfBundles) {
        Map<SubmissionBundles, Integer> detailsOfBundles = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : comboOfBundles.getNumOfBundles().entrySet()) {
            SubmissionBundles submissionBundles = MediaBundles.BUNDLE_LIST.get(codeOfMedia)
                    .stream()
                    .filter(bundles -> bundles.getNumPerBundle() == entry.getKey())
                    .findFirst()
                    .get();
            detailsOfBundles.put(submissionBundles, entry.getValue());
        }
        QuotationItem quotationItem = QuotationItem.builder().codeOfMedia(codeOfMedia).detailsOfBundles(detailsOfBundles).build();
        return quotationItem;
    }


    public ElementsOfCal getElementsOfCal(OrderItem item) {
        List<Integer> typeOfBundles = MediaBundles.BUNDLE_LIST.get(item.getCodeOfMedia())
                .stream()
                .map(bundles -> bundles.getNumPerBundle())
                .collect(Collectors.toList());

        return ElementsOfCal.builder().numOfPost(item.getNumOfPost()).typeOfBundles(typeOfBundles).build();
    }


    public Quotation dealWithOrder(Order order) {
        Calculator calculator = new Calculator();
        List<QuotationItem> quotationItemList = new ArrayList<>();

        for (OrderItem orderItem : order.getOrderItems()) {

            ElementsOfCal elements = getElementsOfCal(orderItem);
            ComboOfBundles comboOfBundles = calculator.calculateBundles(elements);
            quotationItemList.add(formQuotationItem(orderItem.getCodeOfMedia(), comboOfBundles));

        }
        if (quotationItemList.size() > 0) {
            return Quotation.builder().quotationItems(quotationItemList).build();
        }
        return null;
    }


}
