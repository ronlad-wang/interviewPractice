package Chapter4;

import DataStructures.BinaryNode;
import DataStructures.Node;

import javax.swing.tree.TreeNode;

public class CheckSubtree {

    /*
    Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
    algorithm to determine if T2 is a subtree of Tl.
     */

    public static boolean checkSubtree(BinaryNode root1, BinaryNode root2) {
        /*
        The idea is that performing a pre-order traversal on each tree will produce a string that
        contains all the information within the tree. Then we can compare to see if the second string
        is a part of the first string. If it is, then we can say that the second tree is indeed a subtree

        An important caveat - you need to make one modification which is that null nodes also produce
        some kind of marker, say 'X'. Otherwise you can have two non-identical trees that produce
        strings that show they are part of each other.
         */

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        preOrderTraversal(s1, root1);
        preOrderTraversal(s2, root2);


        //indexOf is really useful here, it iterates through s1 and returns the index of the first
        //character of the first instance of a substring that matches the input.
        //if no such instance exists it returns -1.
        return s1.indexOf(s2.toString()) != -1;

        //runtime of this function is O(N + M), where N and M represent the number of nodes in each
        //tree, since we need to iterate through each node in the traversal.
    }

    public static void preOrderTraversal(StringBuilder s, BinaryNode root) {
        //basic pre-order traversal modified to add X to the stringbuilder to represent a null node
        if(root == null) {
            s.append('X');
            return;
        }
        s.append(root.item + " ");
        preOrderTraversal(s, root.left);
        preOrderTraversal(s, root.right);
    }
}
