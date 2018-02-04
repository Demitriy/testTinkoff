package com.task;

public class Main {

    public final static String FIZZ = "Fizz";
    public final static String BUZZ = "Buzz";

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String result = "";
            if (i % 3 == 0) result += FIZZ;
            if (i % 5 == 0) result += BUZZ;
            if (result.isEmpty()) System.out.println(i);
            else System.out.println(result);
        }
    }
}
