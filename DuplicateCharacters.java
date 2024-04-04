//Q4:Write a Java Program to find the duplicate characters in a string.

package myassignment;

import java.util.HashMap;

public class DuplicateCharacters {
    public static void findDuplicates(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Duplicate characters in the string:");
        for (char ch : charCount.keySet()) {
            if (charCount.get(ch) > 1) {
                System.out.println(ch);
            }
        }
    }

    public static void main(String[] args) {
        String input = "java programming";
        findDuplicates(input);
    }
}

