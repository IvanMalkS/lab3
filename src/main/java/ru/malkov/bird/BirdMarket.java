package ru.malkov.bird;

import java.util.List;

public class BirdMarket implements IBirdMarket {
    public void singAllBirds(List<ISingable> birds) {
        for (ISingable bird : birds) {
            bird.sing();
        }
    }
}
