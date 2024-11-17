package ru.malkov.bird;

import java.util.Random;

public class Cuckoo extends Bird implements ISingable {
    private final Random random;

    public Cuckoo() {
        super("Cuckoo");
        this.random = new Random();
    }

    @Override
    public void sing() {
        int count = random.nextInt(10) + 1;
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}