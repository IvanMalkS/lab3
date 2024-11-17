package ru.malkov.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class Node implements IBinaryTree {
    private Integer value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node() {
        this.value = null;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public void add(int value) {
        if (this.value == null) {
            this.value = value;
        } else {
            if (value > this.value) {
                if (rightChild == null) {
                    rightChild = new Node();
                    rightChild.parent = this;
                }
                rightChild.add(value);
            } else {
                if (leftChild == null) {
                    leftChild = new Node();
                    leftChild.parent = this;
                }
                leftChild.add(value);
            }
        }
    }

    @Override
    public boolean remove(int value) {
        Node nodeToRemove = findNode(value);
        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove.leftChild == null && nodeToRemove.rightChild == null) {
            if (nodeToRemove.parent != null) {
                if (nodeToRemove.parent.leftChild == nodeToRemove) {
                    nodeToRemove.parent.leftChild = null;
                } else {
                    nodeToRemove.parent.rightChild = null;
                }
            }
        }

        else if (nodeToRemove.leftChild == null || nodeToRemove.rightChild == null) {
            Node child = (nodeToRemove.leftChild != null) ? nodeToRemove.leftChild : nodeToRemove.rightChild;
            if (nodeToRemove.parent != null) {
                if (nodeToRemove.parent.leftChild == nodeToRemove) {
                    nodeToRemove.parent.leftChild = child;
                } else {
                    nodeToRemove.parent.rightChild = child;
                }
            }
            if (child != null) {
                child.parent = nodeToRemove.parent;
            }
        }

        else {
            Node successor = getMinimum(nodeToRemove.rightChild);
            nodeToRemove.value = successor.value;
            remove(successor.value);
        }
        return true;
    }

    @Override
    public boolean contains(int value) {
        return findNode(value) != null;
    }

    private Node findNode(int value) {
        if (this.value == null) {
            return null;
        }
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            return leftChild != null ? leftChild.findNode(value) : null;
        } else {
            return rightChild != null ? rightChild.findNode(value) : null;
        }
    }

    private Node getMinimum(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    @Override
    public String toString() {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(this, values);
        return values.toString();
    }

    private void inOrderTraversal(Node node, List<Integer> values) {
        if (node != null && node.value != null) {
            inOrderTraversal(node.leftChild, values);
            values.add(node.value);
            inOrderTraversal(node.rightChild, values);
        }
    }
}