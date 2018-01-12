package io.github.mkgerasimenko.tests;

import io.github.mkgerasimenko.core.Car;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * empty JavaDoc.
 */
public class CarTest {

    @Test
    public void someCarMethodReturnsString() {
        final Car audi = new Car();
        final String color = audi.getCarColor();
        assertEquals(color, "Blue", "getCarColor Should return a origin color");
    }
}
