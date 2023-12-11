package com.metrot.crayon_final;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Crayon implements Comparable<Crayon>{
    public static void main(String[] args) {
        List<Crayon> crayons = new ArrayList<>();
        Crayon crayon1 = new Crayon();
        Crayon crayon2 = new Crayon("Blue", 0.5);
        Crayon crayon3 = new Crayon("Red", 0);
        Crayon crayon4 = new Crayon("Yellow", 0.2);
        Crayon crayon5 = new Crayon("White", 0.8);
        crayons.add(crayon1);
        crayons.add(crayon2);
        crayons.add(crayon3);
        crayons.add(crayon4);
        crayons.add(crayon5);

        crayons.forEach(System.out::println);
    }
    private String color;
    private double percentRemaining;

    public Crayon() {
        this.color = "Black";
        this.percentRemaining = 1;
    }

    public Crayon(String color, double percentRemaining) {
        this.color = color;
        this.percentRemaining = percentRemaining;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPercentRemaining() {
        return percentRemaining;
    }

    public void setPercentRemaining(double percentRemaining) throws IllegalArgumentException {
        if (percentRemaining < 0 || percentRemaining > 1) {
            throw new IllegalArgumentException();
        } else {
            this.percentRemaining = percentRemaining;
        }
    }

    @Override
    public String toString() {
        return "Crayon{" +
                "color='" + color + '\'' +
                ", percentRemaining=" + percentRemaining +
                '}';
    }

    @Override
    public int compareTo(Crayon other) {
        int result = this.getColor().compareTo(other.getColor());
        return result;
    }
}
