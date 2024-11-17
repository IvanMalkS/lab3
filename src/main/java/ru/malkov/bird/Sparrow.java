package ru.malkov.bird;

public class Sparrow extends Bird implements ISingable {
    public Sparrow() {
        super("Sparrow");
    }

    @Override
    public void sing() {
        System.out.println("чырык");
    }
}