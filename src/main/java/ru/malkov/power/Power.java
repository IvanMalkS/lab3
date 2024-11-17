package ru.malkov.power;

public class Power implements IPower {
    @Override
    public double calculatePower(String x, String y) {
        try {
            int xInt = Integer.parseInt(x);
            int yInt = Integer.parseInt(y);
            return Math.pow(xInt, yInt);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: Both arguments must be valid integers.");
            return Double.NaN;
        }
    }
}