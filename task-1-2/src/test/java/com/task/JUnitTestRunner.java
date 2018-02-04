package com.task;

import com.task.shapes.triangle.RightTriangleTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class JUnitTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RightTriangleTest.class);
        if (!result.wasSuccessful()) System.out.println("Not Right Triangle. One or more unit-tests was failed.");
        else System.out.println("Right Triangle. All unit-tests was passed.");
    }
}
