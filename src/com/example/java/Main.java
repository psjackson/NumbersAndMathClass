package com.example.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        //create variables used to calculate the total, tax and tip amounts
        double total = 0;
        double taxPercent = 0.025;
        double tipPercent = 0.175;
        //create string variables to display rounded values to the user
        String totalResult;
        String taxAmount;
        String taxOutResult;
        String tipAmountResult;
        String tipOutResult;

        //create a blank list that the values entered by the user can be added to
        List<Double> items = new ArrayList<>();
        //display to the user what the program does
        System.out.println("\nThe program will collect values of items from you, it will then calculate");
        System.out.println("(and display to you), the total value, the tax and the suggested tip amount.");
        System.out.println("----------------------------------------------------------------------------\n");

        //create a sentinel variable and set it to 1
        int request = 1;
        //while loop, while the sentinel variable = 1, ask the user for a value and add it to the array list
        while (request == 1) {
            //use the scanner to get the variable from the user
            Scanner entry = new Scanner(System.in);
            System.out.println("Enter the value of the item (enter 0 to end): ");
            double cost = entry.nextDouble();
            //if the value is greater than 0, add it to the array list
            if (cost > 0) {
                items.add(cost);
            }
            //else if the value is less than 0, display to the user only positive values can be added, dont add to list
            else if (cost < 0) {
                System.out.println("You can only enter positive values.");
            }
            //else (value = 0) set sentinel to 0 which will stop the while loop
            else {
                request = 0;
            }
        }
        //if the list is empty, display to the user that no valid values where entered and program will end
        if (items.isEmpty()){
            System.out.println("You didn't enter any values, the application will now exit.");
        }
        else {
            //use a for loop to calculate the sum of the values in the list
            for (double i : items)
                total += i;

            //use number formatting to display the numbers to 2 decimal places.
            NumberFormat nf = NumberFormat.getNumberInstance() ; //we get the instance of the number
            nf.setGroupingUsed(true) ; // group by threes
            nf.setMaximumFractionDigits(2) ; //set the max number of decimal digits.
            nf.setMinimumFractionDigits(2) ; //set the min number of decimal digits.

            //convert the total to 2 decimal places and display to user
            totalResult = nf.format(total);
            System.out.println("\n------------------------------------------------------------");
            System.out.println("The total value of the items inputted was: \t$" + totalResult);

            //calculate the value of the tax, round to 2 decimal places and display to the user
            double tax = total * taxPercent;
            taxAmount = nf.format(tax);
            System.out.println("The tax due (2.5%) on the total is: \t\t$" + taxAmount);


            //calculate the amount with tax, round to 2 decimal places and display to the user
            double taxOut = total + tax;
            taxOutResult = nf.format(taxOut);
            System.out.println("Total amount with Tax included is: \t\t\t$" + taxOutResult);

            //calculate the value of the tip, round to 2 decimal places and display to the user
            double tipAmount = taxOut * tipPercent;
            tipAmountResult = nf.format(tipAmount);
            System.out.println("The suggested tip amount (of 17.5%) is: \t$" + tipAmountResult);

            //calculate the total with tip included, round to 2 decimal places and display to user
            double tipOut = taxOut + tipAmount;
            tipOutResult = nf.format(tipOut); //rounded operation
            System.out.println("That gives you a suggested total amount of: $" + tipOutResult);
            System.out.println("------------------------------------------------------------");
        }
    }
}