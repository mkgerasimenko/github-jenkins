package io.github.mkgerasimenko.core;

import io.qameta.allure.Step;

/**
 * empty JavaDoc.
 */
public class Car {

    private final String color;

    public Car() {
        this.color = "Blue";
    }

    @Step("Get color of car")
    public String getCarColor() {
        return color;
    }
}
