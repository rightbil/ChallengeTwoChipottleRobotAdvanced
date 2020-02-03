package com.company;

import java.util.*;

public class ChallengeTwoChipottleRobotAdvanced {


    public static String allItems(String[] str, String item, String category) {
        String result = item;
        StringBuilder sb = new StringBuilder();
        if (result.equalsIgnoreCase("all")) {
            for (String s : str) {
                if (!s.equalsIgnoreCase(item)) {
                    sb.append(s + " ");
                }

            }
            result = "all " + category + "{" + sb + "}";
        } else {
            result = item + " " + category;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList("rice", "meat", "beans", "salsa", "veggies", "cheese", "guac", "queso", "sourcream"));
        String[] rice = new String[]{"white", "brown", "all"}; /*"none",*/
        String[] meat = new String[]{"chicken", "steak", "carnidas", "chorizo", "sofritas", "fajita meat", "all"};
        String[] beans = new String[]{"pinto", "black", "all"};
        String[] salsa = new String[]{"mild", "medium", "hot", "all"};
        String[] veggies = new String[]{"lettuce", "fajita veggies", "all"};
        ArrayList<String> selectedCategories;
        ArrayList<String> burrittoSeries;
        Map<String, Integer> itemsTracker = new HashMap<>();
        Random rand;
        int itemsInBurritto;
        StringBuilder sb;
        double totalPrice = 0.0;

        for (int i = 1; i <= 10; i++) {
            // single burritto processor
            selectedCategories = new ArrayList<>();
            rand = new Random();
            sb = new StringBuilder();
            burrittoSeries = new ArrayList<>();

            //itemsTracker= new ArrayList<String>();
            itemsInBurritto = 5 + rand.nextInt(5);
            double pricePerBurritto = (itemsInBurritto * .50) + 3.00;
            String current;
            for (int j = 0; j < itemsInBurritto; j++) {
                current = categories.get(new Random().nextInt(categories.size()));
                if (!selectedCategories.contains(current)) {
                    selectedCategories.add(current);

                } else {
                    j--;
                }
            }// 1st inner for loop ends here
            String item = "";
            for (int k = 0; k < selectedCategories.size(); k++) {
                switch (selectedCategories.get(k).toLowerCase()) {
                    case "rice":
                        item = allItems(rice, rice[rand.nextInt(rice.length)], "rice");
                        burrittoSeries.add(item);
                        break;
                    case "meat":
                        item = allItems(meat, meat[rand.nextInt(meat.length)], "meat");
                        burrittoSeries.add(item);
                        break;
                    case "beans":
                        item = allItems(beans, beans[rand.nextInt(beans.length)], "beans");
                        burrittoSeries.add(item);
                        break;
                    case "salsa":
                        item = allItems(salsa, salsa[rand.nextInt(salsa.length)], "salsa");
                        burrittoSeries.add(item);
                        break;
                    case "veggies":
                        item = allItems(veggies, veggies[rand.nextInt(veggies.length)], "veggies");
                        burrittoSeries.add(item);
                        break;
                    case "cheese":
                        burrittoSeries.add("cheese");
                        break;
                    case "guac":
                        burrittoSeries.add("guac");
                        break;
                    case "queso":
                        burrittoSeries.add("queso");
                        break;
                    case "sourcream":
                        burrittoSeries.add("sour cream");
                        break;
                    default:
                }
            }// end of inner loop
            for (String str : burrittoSeries) {
                if (!itemsTracker.containsKey(str)) {
                    itemsTracker.put(str, 1);
                } else {
                    itemsTracker.put(str, itemsTracker.get(str) + 1);

                }
            }
            totalPrice = totalPrice + pricePerBurritto;
        } // end of loop
        System.out.println("This order has " + itemsTracker + String.format(" $%.2f", totalPrice));

        System.out.println("MC Burritto factoring simulation receipt");
        int lengthOfReceiptContent = itemsTracker.toString().length();
        for(int indexFrom=0; indexFrom < lengthOfReceiptContent; indexFrom+=50)
        {
            int indexTo= indexFrom+50;
            if(indexTo < lengthOfReceiptContent) {
                System.out.println(itemsTracker.toString().substring(indexFrom, indexTo));
            }
            else// when it is not a multiple of 50 to avoid going out of index
            {
                System.out.println(itemsTracker.toString().substring(indexTo-50,lengthOfReceiptContent));
            }
        }
    } // end of main
}// end of outer loop

