package Chapter4;

import DataStructures.BinaryNode;

public class ValidateBST {
    /*
    Implement a function to check if a binary tree is a binary search tree.
     */

    public static boolean isBST(BinaryNode root) {
        //we can take advantage of the fact that if a node is the root of a binary tree, either its
        //subnodes are all BSTs or they are null.

        if(root.left != null && (!isBST(root.left) || root.left.item > root.item)) {
            //if the left isn't a BST, then we have a problem. If the left's root is greater than our
            //root item, then we have a problem
            return false;
        }
        if(root.right != null && (!isBST(root.right) || root.right.item < root.item)) {
            //vice versa here
            return false;
        }

        return true;


    }

}
