package com.lawrence.bundlescalculator;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@UtilityClass
public class OrderInput {

    public Order inputByConsole() {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] inputContent = input.split(" ");

        if (inputContent.length > 0) {

            List<OrderItem> orderItems = new ArrayList<>();

            for (int i = 1; i < inputContent.length; i += 2) {

                OrderItem item = OrderItem.builder().codeOfMedia(inputContent[i]).numOfPost(Integer.parseInt(inputContent[i - 1])).build();
                orderItems.add(item);

            }
            if (orderItems.size() > 0) {
                Order order = Order.builder().orderItems(orderItems).build();
                return order;
            }

        }

        return null;

    }

    public Order fileReader() {
        FileReader reader = null;
        BufferedReader in = null;
        String line;
        Calculator calculator = null;
        List<OrderItem> orderItems = new ArrayList<>();

        try {
            reader = new FileReader("Order.txt");
            in = new BufferedReader(reader);
            while ((line = in.readLine()) != null) {

                String num = line.split(" ")[0];
                String type = line.split(" ")[1];

                OrderItem orderItem = OrderItem.builder().numOfPost(Integer.parseInt(num)).codeOfMedia(type).build();
                orderItems.add(orderItem);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (orderItems.size() > 0) {
                return Order.builder().orderItems(orderItems).build();
            } else {
                return null;
            }
        }
    }

    public static Menu getResponse() {


        System.out.println("-----------Menu-----------");
        for (Menu m : Menu.values()) {
            System.out.println(m.getOption() + ". " + m.getContent());
        }


        System.out.println("Please enter your choice!");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        for (Menu m : Menu.values()) {
            if (choice.equalsIgnoreCase(m.getOption()))
                return m;

        }
        System.out.println("Invalid input, please try again!");


        return null;
    }


}
