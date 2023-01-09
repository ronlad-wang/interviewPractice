package Chapter4;

import DataStructures.BinaryNode;
import DataStructures.Node;
import jdk.incubator.vector.VectorOperators;

public class FirstCommonAncestor {

    /*
    Design an algorithm and write code to find the first common ancestor
    of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
    NOTE: This is not necessarily a binary search tree.
     */

    public static BinaryNode findAncestor(BinaryNode b1, BinaryNode b2) {
        /*
        First idea was to iterate upwards from b1 and perform a DFS search
        at each level for b2. You can make a slight optimization by knowing you don't need
        to perform a search on the subnode you just came from as you iterate upwards, but
        overall the runtime of such a function is something like O(N^2).

        The main issue is that we don't know what level of the tree each node is on. However, we can
        find the level by iterating upwards from each individual node until we reach the root node,
        which will enable us to find the height of each node.
        Then, we can iterate upwards from the lower of the two nodes until we are level.
        Once they are level this means we can repeatedly compare the parents of the two nodes as we
        iterate upwards. Then, if there is an intersection, we are guaranteed to find it.

        This function has runtime O(D) where D is the depth of lower of the two nodes
        */

        int b1Depth = 0;
        int b2Depth = 0;
        BinaryNode b1Pointer = b1;
        BinaryNode b2Pointer = b2;


        //we begin by finding the depths of each of the two nodes

        while(b1Pointer != null) {
            b1Pointer = b1Pointer.parent;
            b1Depth++;
        }

        while(b2Pointer != null) {
            b2Pointer = b2Pointer.parent;
            b2Depth++;
        }

        //next we need to find which of the two is lower, and bring it up to the level
        //of the higher node

        int minDepth;
        int maxDepth;
        BinaryNode lowerPointer;
        BinaryNode higherPointer;

        if(b1Depth < b2Depth) {
            minDepth = b1Depth;
            maxDepth = b2Depth;
            lowerPointer = b2;
            higherPointer = b1;
        }
        else {
            minDepth = b2Depth;
            maxDepth = b1Depth;
            lowerPointer = b1;
            higherPointer = b2;
        }

        //we bring the lower node upwards

        while(maxDepth > minDepth) {
            lowerPointer = lowerPointer.parent;
            maxDepth--;
        }

        //once they are on the same level we can iterate upwards at the same place and know that
        //eventually the two will intersect

        while(higherPointer != lowerPointer) {
            lowerPointer = lowerPointer.parent;
            higherPointer = higherPointer.parent;
        }

        return higherPointer;
    }
}
