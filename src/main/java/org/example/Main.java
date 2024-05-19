package org.example;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println(encryptedMethod("abcd", 2));
    }

    public static String encryptedMethod(String encrypted, int k) {

        char[] alphabets = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String encryptedToUpper = encrypted.toUpperCase();
        String saveEncrypted = "";

        char[] charArray = encryptedToUpper.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < alphabets.length; j++) {
                if (charArray[i] == alphabets[j]) {
                    if (j - k < 0) {
                        saveEncrypted += alphabets[alphabets.length + j - k];
                    } else saveEncrypted += alphabets[j - k];
                }
            }
        }
        return saveEncrypted;
    }
}