package Chapter4;

import DataStructures.BinaryNode;

public class ValidateBST {
    /*
    Implement a function to check if a binary tree is a binary search tree.
     */

    public static boolean isBST(BinaryNode root, Integer min, Integer max) {
        //we should check first to understand the properties of how duplicate values are handled

        //we can take advantage of the fact that if a node is the root of a binary tree, either its
        //subnodes are all BSTs or they are null. The two criteria are then, if the subnodes are
        //BSTs, and if the root node of those subtrees are correct compared to our current item

        if(root == null) {
            return true;
        }
        if((min != null && root.item <= min) || (max != null && root.item > max)) {
            return false;
        }
        if(!isBST(root.left, min, root.item) || !isBST(root.right, root.item, max)) {
            return false;
        }
        return true;
    }

}
