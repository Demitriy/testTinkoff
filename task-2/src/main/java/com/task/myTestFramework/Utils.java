package com.task.myTestFramework;

public class Utils {
    public static void sleepStatic(long second) {
        try {
            Thread.currentThread().sleep(second * 1000);
        } catch (Exception e) {}
    }
}
