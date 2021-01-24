package com.lawrence.bundlescalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrderOutput {

    public static void output(Quotation quotation) {

        List<QuotationItem> quotationItems = quotation.getQuotationItems();


        System.out.println("The details of quotation is shown below:");
        System.out.println(" ");

        for (QuotationItem item : quotationItems) {

            System.out.println(item.getTotalNumOfPost() + " " + item.getCodeOfMedia() + " $" + item.getTotalPrice());

            for (Map.Entry<SubmissionBundles, Integer> entry : item.getDetailsOfBundles().entrySet()) {

                System.out.println("  " + entry.getValue() + " x " + entry.getKey().getNumPerBundle() + " $" + entry.getKey().getPriceOfBundle());
            }
        }
        System.out.println(" ");

    }

    public static void fileWriter(Quotation quotation) {
        try {
            FileWriter writer = new FileWriter("Quotation");
            BufferedWriter out = new BufferedWriter(writer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


