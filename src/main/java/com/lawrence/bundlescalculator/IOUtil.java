package com.lawrence.bundlescalculator;

import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@UtilityClass
public class IOUtil {

    public List<Post> inputByConsole() {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] inputContent = input.split(" ");

        if (inputContent.length > 0) {
            List<Post> order = new ArrayList<>();

            for (int i = 1; i < inputContent.length; i += 2) {

                switch (inputContent[i]) {

                    case "IMG":
                        Image image = Image.builder().code("IMG").number(Integer.parseInt(inputContent[i - 1])).build();
                        order.add(image);
                        break;

                    case "FLAC":
                        Audio audio = Audio.builder().code("FLAC").number(Integer.parseInt(inputContent[i - 1])).build();
                        order.add(audio);
                        break;

                    case "VID":
                        Video video = Video.builder().code("VID").number(Integer.parseInt(inputContent[i - 1])).build();
                        order.add(video);
                        break;

                    default:
                        continue;
                }
            }
            if (order.size() > 0) {
                return order;
            }

        }

        return null;

    }

    public Calculator fileReader() {
        FileReader reader = null;
        BufferedReader in = null;
        String line;
        Calculator calculator = null;

        try {
            reader = new FileReader("Order.txt");
            in = new BufferedReader(reader);
            while ((line = in.readLine()) != null) {

                calculator = new Calculator();
                String num = line.split(" ")[0];
                String type = line.split(" ")[1];
                List<Post> Order = new ArrayList<>();

                switch (type) {

                    case "IMG":
                        Image image = Image.builder().code("IMG").number(Integer.parseInt(num)).build();
                        Order.add(image);
                        break;

                    case "FLAC":
                        Audio audio = Audio.builder().code("FLAC").number(Integer.parseInt(num)).build();
                        Order.add(audio);
                        break;

                    case "VID":
                        Video video = Video.builder().code("VID").number(Integer.parseInt(num)).build();
                        Order.add(video);
                        break;
                }

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
            if (calculator != null) {
                return calculator;
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


    public void output(List<Post> order, List<Bundle> quotation) {

        List<String> typeList = quotation.stream().map(bundle -> bundle.getCode()).distinct().collect(Collectors.toList());

        System.out.println("The details of quotation is shown below:");
        System.out.println(" ");

        for (String type : typeList) {
            int totalNum = 0;
            totalNum = order.stream().filter(e -> e.getCode() == type).findFirst().orElse(null).getNumber();

            double sum = quotation.stream()
                    .filter(bundle -> bundle.getCode().equals(type))
                    .mapToDouble(bundle -> bundle.getNumOfBundles() * bundle.getPrice())
                    .summaryStatistics().getSum();

            System.out.println(totalNum + " " + type + " $" + sum);

            quotation
                    .stream()
                    .filter(bundle -> bundle.getCode().equals(type))
                    .forEach(bundle -> System.out.println("  " + bundle.getNumOfBundles() + " x " + bundle.getNumOfPosts() + " $" + bundle.getPrice()));
        }

    }

    public void fileWriter(List<Bundle> quotation) {
        try {
            FileWriter writer = new FileWriter("Quotation");
            BufferedWriter out = new BufferedWriter(writer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
