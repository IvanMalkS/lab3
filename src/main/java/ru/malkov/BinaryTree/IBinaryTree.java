package ru.malkov.BinaryTree;

public interface IBinaryTree {
    void add(int value);
    boolean remove(int value);
    boolean contains(int value);
    String toString();
}