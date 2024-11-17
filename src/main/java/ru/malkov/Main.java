package ru.malkov;

import ru.malkov.BinaryTree.BinaryNode;
import ru.malkov.bird.Cuckoo;
import ru.malkov.bird.ISingable;
import ru.malkov.bird.Parrot;
import ru.malkov.bird.Sparrow;
import ru.malkov.employee.Department;
import ru.malkov.employee.Employee;
import ru.malkov.point.Point;
import ru.malkov.point.Point3D;
import ru.malkov.bird.BirdMarket;
import ru.malkov.power.Power;
import ru.malkov.time.Time;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Демонстрация работы с временем
        Time time1 = new Time(90000); // 25 hours
        System.out.println("Time 1: " + time1); // Time 1: 01:00:00
        Time time2 = new Time(25, 25,25); // 25 hours 25 minutes 25 seconds
        System.out.println("Time 2: " + time2); // Time 2: 01:25:25

        // Демонстрирую работы с начальником отдела
        Department newDepartment = new Department("Пятёрочка");
        Employee vasya = new Employee("vasya", newDepartment);
        Department anotherDepartment = new Department("Магнит");
        newDepartment.addEmployee(vasya);
        newDepartment.setBoss(vasya);
        anotherDepartment.addEmployee(vasya);
        // anotherDepartment.setBoss(vasya); // IllegalStateException: Boss is already set

        // Демонстрация работы с бинарным деревом
        BinaryNode root = new BinaryNode();
        root.add(3);
        root.add(5);
        root.add(4);
        root.add(7);
        root.add(1);
        root.add(2);
        System.out.println(root); // Вывод: [1, 2, 3, 4, 5, 7]


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
        List<ISingable> birds = List.of(
                new Sparrow(),
                new Cuckoo(),
                new Parrot("I use Arch, btw")
        );
        BirdMarket birdMarket = new BirdMarket();
        birdMarket.singAllBirds(birds);

        // Демонстрирую работу с возведением в степень.
        Power power = new Power();
        System.out.println(power.calculatePower("3", "3"));
        System.out.println(power.calculatePower("3", "4"));

    }
}