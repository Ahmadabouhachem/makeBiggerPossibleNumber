package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        //the methode give the biggest number back, but it swaps the even numbers with each others and the odd numbers with each other. 1234 --> 3412
        System.out.println(makeBiggerPossibleNumber("234541"));
    }

    public static String makeBiggerPossibleNumber(String numberStr) {

        //converting string to integer
        int nubmers = Integer.parseInt(numberStr);

        //converting integer to list of integers
        List<Integer> numbersList = intToArray(nubmers);

        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        //adding the even numbers to list and odd numbers to another list
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                evens.add(numbersList.get(i));
            } else {
                odds.add(numbersList.get(i));
            }
        }
        // sort the list bigger to lower
        evens = evens.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        odds = odds.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        //adding the number to string
        String biggestNumberStr = "";

        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                biggestNumberStr += "" + evens.getFirst();
                evens.removeFirst();
            } else {
                biggestNumberStr += "" + odds.getFirst();
                odds.removeFirst();
            }
        }
        return biggestNumberStr;
    }

    public static List<Integer> intToArray(int n) {
        List<Integer> result = new ArrayList<>();
        while (n != 0) {
            result.add(0, n % 10);
            n /= 10;
        }
        return result;
    }
}