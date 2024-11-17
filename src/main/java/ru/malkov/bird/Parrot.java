package ru.malkov.bird;

import java.util.Random;

public class Parrot extends Bird implements ISingable {
    private final String text;
    private final Random random;

    public Parrot(String text) {
        super("Parrot");
        this.text = text;
        this.random = new Random();
    }

    @Override
    public void sing() {
        int length = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, length));
    }
}