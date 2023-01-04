package Chapter2;

import DataStructures.Node;

public class DeleteMiddleNode {
    /*
    Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list,
    given only access to that node.
     */

    public static void deleteMiddle(Node n) {
        //this can be done by copying the data from the next node and deleting the next node
        //notice that this is impossible to do if you are given the last node
        //luckily the question specifies that the node you are given cannot be the last node

        n.item = n.next.item;
        n.next = n.next.next;
    }
}
