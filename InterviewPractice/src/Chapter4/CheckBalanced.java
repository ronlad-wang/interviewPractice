package Chapter4;

import DataStructures.BinaryNode;

public class CheckBalanced {
    /*
    Implement a function to check if a binary tree is balanced. For the purposes of
    this question, a balanced tree is defined to be a tree such that the heights of the
    two subtrees of any node never differ by more than one.
     */

    public static int isBalanced(BinaryNode root) {
        int leftDepth;
        int rightDepth;

        if(root.left == null) {
            //this is our base case. If one of our roots are null, then there is nothing left
            //the depth is therefore 0.
            leftDepth = 0;
        }
        else {
            leftDepth = isBalanced(root.left);
            //if the root isn't null we need to find out how deep it is, so we recursively call
            //our function on it

            if(leftDepth == 0) {
                //I created a special case where we return 0. There is no way for our function
                //to naturally return 0 as we will see below. If our function returns 0, it
                //is because we have found an inbalance somewhere below us.
                //In that case by passing 0 back we can save time
                return 0;
            }
        }

        //repeat process on the right
        if(root.right == null) {
            rightDepth = 0;
        }
        else {
            rightDepth = isBalanced(root.right);
            if(rightDepth == 0) {
                return 0;
            }
        }

        //checks to see if the difference in depths is an inbalance
        if(Math.abs(leftDepth - rightDepth) > 1) {
            //if so we return our special case 0 to let upper nodes know we've found a problem
            return 0;
        }

        else {
            //otherwise we return the larger of the two plus 1 to represent the additional depth of
            //the current node.
            //Because we always add one, it is impossible to get 0 naturally.
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        
    }
}
