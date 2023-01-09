package Chapter4;

import DataStructures.BinaryNode;

public class Successor {
    /*
    Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
    binary search tree. You may assume that each node has a link to its parent.
     */

    public static BinaryNode findSuccessor(BinaryNode root) {
        //In-Order Successor moves from left to the current node, then to the right.
        //First we should check the right child of the current node, and perform an in order check on it
        //If the right child does not exist, then either the node we are currently at is the left child
        //of its parent, the right child of the parent, or the parent does not exist
        //if it is the left child of the parent, by in-order traversal we need to return the parent's
        //item
        //If the parent does not exist, this is the last node in an in-order traversal, and so
        //we need to indicate an error
        //If it is the right child, we need to find the successor of the parent's parent.
        //This in turn has two cases, if the parent's parent does not exist then the current node
        //is the last node in the traversal
        //If the parent's parent does exist, we need to find its successor, which requires iterating
        //through the parents'

        if(root.right != null) {
            //if the right node exists then the successor node is the leftmost node in that subtree
            BinaryNode temp = root.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        //if the right node doesn't exist that means we've exhausted the current subtree and
        //need to return to the parent
        //if we are not the left child we must be the right child. We have to iterate until either
        //we are at the top of the entire tree or find that the current node is the left child of
        //its parent. When we are the left child, then we need to return the parent's item

        //cut out the previous two if statements since they were extraneous and the cases they covered
        //are covered better by shifting slowrunner and fastrunner back by one.
        BinaryNode slowRunner = root;
        BinaryNode fastRunner = root.parent;

        while(fastRunner != null) {
            if(slowRunner == fastRunner.left) {
                return slowRunner;
            }
            slowRunner = slowRunner.parent;
            fastRunner = fastRunner.parent;
        }

        //If fastRunner becomes null before the loop terminates, it implies that our starting node
        //was the rightmost value in the whole tree, meaning it was the last item in the in-order traversal
        System.out.println("This is the final node in our in-order traversal");
        return null;
    }
}
