package com.task.shapes.utils;

import com.task.shapes.exceptions.NotExistingShapeException;
import com.task.shapes.triangle.ITriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class TriangleUtil {

    private static List<Point> convertTriangleToCoordinates(ITriangle triangle) {
        if (triangle == null) throw new NotExistingShapeException();
        Point p1 = new Point(triangle.getX1(), triangle.getY1());
        Point p2 = new Point(triangle.getX2(), triangle.getY2());
        Point p3 = new Point(triangle.getX3(), triangle.getY3());
        Vector<Point> coordinates = new Vector<>();
        coordinates.add(p1);
        coordinates.add(p2);
        coordinates.add(p3);
        return coordinates;
    }

    private static List<Point> convertTriangleToVectors(ITriangle triangle) {
        List<Point> coordinates = convertTriangleToCoordinates(triangle);
        List<Point> sides = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            sides.add(coordinates.get(0).sub(coordinates.get(1)));
            coordinates.add(coordinates.remove(0));
        }
        return sides;
    }

    public static List<Double> getLengthOfTriangleSides(ITriangle triangle) {
        return convertTriangleToVectors(triangle).stream().map((a) -> a.getLength()).collect(Collectors.toList());
    }

    public static List<Double> getProductOfTrianleSides(ITriangle triangle) {
        List<Point> vectors = convertTriangleToVectors(triangle);
        List<Double> products = new ArrayList<>();
        for (int i = 0; i < vectors.size(); i++) {
            products.add(vectors.get(0).product(vectors.get(1)));
            vectors.add(vectors.remove(0));
        }
        return products;
    }
}