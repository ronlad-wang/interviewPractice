package Chapter4;

import DataStructures.BinaryNode;

import java.util.Arrays;

public class MinimalTree {

    /*
    Given a sorted (increasing order) array with unique integer elements, write an
    algorithm to create a binary search tree with minimal height.
     */

    public static BinaryNode constructBinaryTree(int[] sortedArray) {
        //realize that the middle item in the sortedArray should be the root node of the binary tree
        //we can repeat this process recursively to create a tree with the minimal height

        if(sortedArray.length == 0) {
            return null;
        }
        BinaryNode middle = new BinaryNode(sortedArray[sortedArray.length / 2]);
        middle.left = constructBinaryTree(Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2));
        middle.right = constructBinaryTree(Arrays.copyOfRange(sortedArray, sortedArray.length/2 + 1, sortedArray.length));
        return middle;
    }

    public static void main(String[] args) {
        int[] i = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        constructBinaryTree(i).printTree();

    }
}
