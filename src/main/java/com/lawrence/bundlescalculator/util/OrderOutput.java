package com.lawrence.bundlescalculator.util;

import com.lawrence.bundlescalculator.model.Quotation;
import com.lawrence.bundlescalculator.model.SubmissionBundles;
import com.lawrence.bundlescalculator.model.QuotationItem;
import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UtilityClass
public class OrderOutput {

    public void output(Quotation quotation) {

        List<QuotationItem> quotationItems = quotation.getQuotationItems();


        System.out.println("The details of quotation is shown below:");
        System.out.println(" ");

        for (QuotationItem item : quotationItems) {

            System.out.println(item.getTotalNum() + " " + item.getCodeOfMedia() + " $" + item.getTotalPrice());

            for (Map.Entry<SubmissionBundles, Integer> entry : item.getDetailsOfBundles().entrySet()) {

                System.out.println("  " + entry.getValue() + " x " + entry.getKey().getNumPerBundle() + " $" + entry.getKey().getPriceOfBundle());
            }
        }
        System.out.println(" ");

    }

    public void fileWriter(Quotation quotation) {
        try {
            FileWriter writer = new FileWriter("Quotation");
            BufferedWriter out = new BufferedWriter(writer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


