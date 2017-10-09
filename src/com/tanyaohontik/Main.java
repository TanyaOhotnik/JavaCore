package com.tanyaohontik;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        sayHello("Max");
        System.out.println(sum(new int[]{1, 2, 3, 4}));
        System.out.println(multiplies(new int[]{1, 2, 3, 4}));
        System.out.println(reverseUsingBuiltInMethod("I am testing"));
        System.out.println(reverseUsingArray("I am testing"));
        System.out.println("isPalindrome "+isPalindrome("radar"));
        histogram(new int[]{4, 9, 7});
        System.out.println(caesarCipher("xyz", 2));
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        diagonalReverse(matrix);
        printMatrix(matrix);

//        game(4, 8);
        System.out.println("Check brackets " + checkBrackets("[[][]]"));
        findFrequency("abcdaabcd");
        decToBin(10);
        System.out.println();
        decToBin(25);
        System.out.println();
    }

    private static void findFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if (!frequencyMap.containsKey(currentCharacter))
                frequencyMap.put(currentCharacter, 1);
            else frequencyMap.put(currentCharacter, frequencyMap.get(currentCharacter) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public static void sayHello(String arg) {
        System.out.printf("Heelo, %s!\n", arg);
    }

    public static int sum(int[] numbers) {
        if (numbers.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    public static int multiplies(int[] numbers) {
        if (numbers.length == 0) return 0;
        int result = 1;
        for (int i = 0; i < numbers.length; i++) {
            result *= numbers[i];
        }
        return result;
    }

    public static String reverseUsingBuiltInMethod(String str) {
        StringBuilder resultStr = new StringBuilder(str);
        return resultStr.reverse().toString();
    }

    public static String reverseUsingArray(String str) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            resultStr.append(str.charAt(i));
        }
        return resultStr.toString();
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void histogram(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static String caesarCipher(String str, int key) {
        StringBuilder resultStr = new StringBuilder();
        str = str.toLowerCase();
        int size = str.length();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) + key > 'z') {
                resultStr.append((char) ('a' + (key - ('z' - str.charAt(i)) - 1)));
            } else resultStr.append((char) (str.charAt(i) + key));
        }
        return resultStr.toString();
    }

    public static int[][] diagonalReverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public static void game(int a, int b) {
        Random rand = new Random();
        int realNumber = a + rand.nextInt(b);
        System.out.println("Enter number:");
        int guess = getInputNumber();
        while (true) {
            if (guess == realNumber) {
                System.out.println("Congratulations! You guess the number");
                return;
            } else {
                System.out.println("Try again!");
                guess = getInputNumber();
            }
        }

    }

    public static int getInputNumber() {
        Scanner in = new Scanner(System.in);
        int guess = 0;
        while (true) {
            try {
                guess = Integer.parseInt(in.nextLine());
                return guess;
            } catch (NumberFormatException ex) {
                System.out.println("Wrong input format, try again!");
            }
        }
    }

    public static boolean checkBrackets(String str) {
        int openingBracket = 0, closingBracket = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[')
                openingBracket++;
            if (str.charAt(i) == ']')
                closingBracket++;
            if (closingBracket > openingBracket) return false;
        }
        return true;
    }

    public static void decToBin(int dec) {

        if (dec == 0 || dec == 1)
            System.out.print(dec);
        else {
            decToBin(dec / 2);
            System.out.print(dec % 2);
        }
    }

}
