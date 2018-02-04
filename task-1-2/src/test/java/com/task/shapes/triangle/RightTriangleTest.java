package com.task.shapes.triangle;

import com.task.shapeProviders.ITriangleProvider;
import com.task.shapes.utils.TriangleUtil;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class RightTriangleTest {

    @DataPoint
    public static ITriangle triangle = ITriangleProvider.getTriangle();

    @Theory
    public void triangleIsNotNull(ITriangle triangle) {
        assertNotNull(triangle);
    }

    @Theory
    public void triangleHaveAllSidesGreaterThanZero(ITriangle triangle) {
        for (Double side : TriangleUtil.getLengthOfTriangleSides(triangle)) assertTrue(side > 0);
    }

    @Theory
    public void triangleHaveSumOfAnyTwoSidesGreaterThenRest(ITriangle triangle) {
        List<Double> sides = TriangleUtil.getLengthOfTriangleSides(triangle);
        for (int i = 0; i < sides.size(); i++) {
            assertTrue(sides.get(0) + sides.get(1) < sides.get(2));
            sides.add(sides.remove(0));
        }
    }

    @Theory
    public void triangleHaveCosAngleIsEqualToOne(ITriangle triangle) {
        List<Double> products = TriangleUtil.getProductOfTrianleSides(triangle);
        assertTrue(products.stream().anyMatch((a) -> a.equals(new Double(0.0))));
    }
}