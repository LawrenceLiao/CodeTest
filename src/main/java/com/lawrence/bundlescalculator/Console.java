package com.lawrence.bundlescalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) throws ClassNotFoundException {

        Menu response = null;

        do {
            response = IOUtil.getResponse();

            switch (response) {

                case INPUT_ORDER:
                    List<Bundle> quotation = new ArrayList<>();

                    System.out.println("Please type your order!");

                    List<Post> orderList = IOUtil.inputByConsole();

                    //Calculator calculator = fileReader();

                    if (orderList == null) {
                        System.out.println("No order provided!");
                        return;
                    }

                    for(Post p : orderList){
                        quotation.addAll(Calculator.calculateBundles(p));

                    }

                    IOUtil.output(orderList, quotation);
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
