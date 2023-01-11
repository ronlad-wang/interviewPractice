package Chapter4;

import java.util.Random;

public class RandomNode {
    /*
    You are implementing a binary search tree class from scratch, which, in addition
    to insert, find, and delete, has a method getRandomNode() which returns a random node
    from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
    for getRandomNode, and explain how you would implement the rest of the methods.
     */

    //The easiest implementation would be to make an arrayList of nodes that expands and contracts as you
    //add or remove nodes. This would enable getRandomNode() to have runtime of O(1), since we
    //just randomly generate an index of the arrayList and return that node.
    //To implement this solution we would need to have an additional memory allocation of O(N),
    //since we need to keep track of every node.
    //Add would still have the same runtime but remove would be more complicated bc you'd need to
    //remove the node from the arrayList, taking O(N) time

    //The more complicated implementation:
    //each node keeps track of the size of the tree coming from itself, (size includes itself).
    // The probability of returning
    //the item at each node is 1/n, where n is that size, and the probability of going left or right
    //is the size of left/right * 1/n. You perform this recursively, starting at the top and you
    //have an equal chance of everything being returned
    //add and remove are modified, but still easy to implement - you just need to update the size variable

    public int SIZE;
    public int item;
    public RandomNode left;
    public RandomNode right;
    public RandomNode parent;


    public RandomNode(int i, RandomNode p) {
        item = i;
        SIZE = 1;
        parent = p;
    }
    public RandomNode(int i) {
        item = i;
        SIZE = 1;
        parent = null;
    }

    public RandomNode getRandomNode() {
        Random random = new Random();
        int index = random.nextInt(SIZE);
        if(index == 1) {
            return this;
        }
        if(index < 1 + left.SIZE) {
            return left.getRandomNode();
        }
        return right.getRandomNode();
    }

    public void add(int i) {
        SIZE++;
        if(i < item) {
            if(left != null) {
                //we need to implement a recursive solution because we need the size counter
                //of all subsequent nodes to increment as well
                left.add(i);
            }
            else {
                left = new RandomNode(i, this);
            }
        }
        else {
            if(right != null) {
                right.add(i);
            }
            else {
                right = new RandomNode(i, this);
        }
    }
} }
