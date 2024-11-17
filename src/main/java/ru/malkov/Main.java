package ru.malkov;

import ru.malkov.bird.Cuckoo;
import ru.malkov.bird.ISingable;
import ru.malkov.bird.Parrot;
import ru.malkov.bird.Sparrow;
import ru.malkov.point.Point;
import ru.malkov.point.Point3D;
import ru.malkov.bird.BirdMarket;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Демонстрация работы с точками
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);
        Point point3 = new Point(3.0, 4.0);

        System.out.println(point1); // Вывод: {1.00;2.00}
        System.out.println(point2); // Вывод: {1.00;2.00}
        System.out.println(point3); // Вывод: {3.00;4.00}

        System.out.println(point1.equals(point2)); // Вывод: true
        System.out.println(point1.equals(point3)); // Вывод: false

        Point3D point3D1 = new Point3D(1.0, 2.0, 3.0);
        Point3D point3D2 = new Point3D(1.0, 2.0, 3.0);
        Point3D point3D3 = new Point3D(4.0, 5.0, 6.0);

        System.out.println(point3D1); // Вывод: {1.00;2.00;3.00}
        System.out.println(point3D2); // Вывод: {1.00;2.00;3.00}
        System.out.println(point3D3); // Вывод: {4.00;5.00;6.00}

        System.out.println(point3D1.equals(point3D2)); // Вывод: true
        System.out.println(point3D1.equals(point3D3)); // Вывод: false

        List<ISingable> birds = List.of(
                new Sparrow(),
                new Sparrow(),
                new Cuckoo(),
                new Cuckoo(),
                new Parrot("Hello, world!"),
                new Parrot("Java is fun!")
        );


        BirdMarket birdMarket = new BirdMarket();
        birdMarket.singAllBirds(birds);
    }
}