package com.lawrence.bundlescalculator.service;

import com.lawrence.bundlescalculator.algorithm.Calculator;
import com.lawrence.bundlescalculator.algorithm.QuotationItem;
import com.lawrence.bundlescalculator.model.Order;
import com.lawrence.bundlescalculator.model.OrderItem;
import com.lawrence.bundlescalculator.model.Quotation;
import com.lawrence.bundlescalculator.util.Menu;
import com.lawrence.bundlescalculator.util.OrderInput;
import com.lawrence.bundlescalculator.util.OrderOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorStarter {

    public static void main(String[] args) {

        Menu response = null;

        do {
            response = OrderInput.getResponse();

            switch (response) {

                case INPUT_ORDER:

                    System.out.println("Please type your order!");

                    Order order = OrderInput.inputByConsole();

                    //Calculator calculator = fileReader();

                    if (order == null) {
                        System.out.println("No order provided!");
                        return;
                    }

                    List<QuotationItem> quotationItems = new ArrayList<>();

                    for (OrderItem orderItem : order.getOrderItems()) {
                        quotationItems.add(Calculator.calculateBundles(orderItem));
                    }
                    Quotation quotation = Quotation.builder().quotationItems(quotationItems).build();

                    OrderOutput.output(quotation);

                    break;

                case EXIT:
                    System.out.println("Are you sure to exit the system? Press Y to confirm");
                    Scanner sc = new Scanner(System.in);
                    String confirmation = sc.nextLine();
                    if (confirmation.equalsIgnoreCase("Y")) {
                        System.out.println("------Thanks!------");
                        System.exit(0);
                    }
                    break;

            }

        } while (true);

    }
}
