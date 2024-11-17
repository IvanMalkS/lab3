package ru.malkov.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryNode implements IBinaryTree {
    private Integer value;
    private BinaryNode parent;
    private BinaryNode leftChild;
    private BinaryNode rightChild;

    public BinaryNode() {
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
                    rightChild = new BinaryNode();
                    rightChild.parent = this;
                }
                rightChild.add(value);
            } else {
                if (leftChild == null) {
                    leftChild = new BinaryNode();
                    leftChild.parent = this;
                }
                leftChild.add(value);
            }
        }
    }

    @Override
    public boolean remove(int value) {
        BinaryNode binaryNodeToRemove = findNode(value);
        if (binaryNodeToRemove == null) {
            return false;
        }

        if (binaryNodeToRemove.leftChild == null && binaryNodeToRemove.rightChild == null) {
            if (binaryNodeToRemove.parent != null) {
                if (binaryNodeToRemove.parent.leftChild == binaryNodeToRemove) {
                    binaryNodeToRemove.parent.leftChild = null;
                } else {
                    binaryNodeToRemove.parent.rightChild = null;
                }
            }
        }

        else if (binaryNodeToRemove.leftChild == null || binaryNodeToRemove.rightChild == null) {
            BinaryNode child = (binaryNodeToRemove.leftChild != null) ? binaryNodeToRemove.leftChild : binaryNodeToRemove.rightChild;
            if (binaryNodeToRemove.parent != null) {
                if (binaryNodeToRemove.parent.leftChild == binaryNodeToRemove) {
                    binaryNodeToRemove.parent.leftChild = child;
                } else {
                    binaryNodeToRemove.parent.rightChild = child;
                }
            }
            if (child != null) {
                child.parent = binaryNodeToRemove.parent;
            }
        }

        else {
            BinaryNode successor = getMinimum(binaryNodeToRemove.rightChild);
            binaryNodeToRemove.value = successor.value;
            remove(successor.value);
        }
        return true;
    }

    @Override
    public boolean contains(int value) {
        return findNode(value) != null;
    }

    private BinaryNode findNode(int value) {
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

    private BinaryNode getMinimum(BinaryNode binaryNode) {
        while (binaryNode.leftChild != null) {
            binaryNode = binaryNode.leftChild;
        }
        return binaryNode;
    }

    @Override
    public String toString() {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(this, values);
        return values.toString();
    }

    private void inOrderTraversal(BinaryNode binaryNode, List<Integer> values) {
        if (binaryNode != null && binaryNode.value != null) {
            inOrderTraversal(binaryNode.leftChild, values);
            values.add(binaryNode.value);
            inOrderTraversal(binaryNode.rightChild, values);
        }
    }
}