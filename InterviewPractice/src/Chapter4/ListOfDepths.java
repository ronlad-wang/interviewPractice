package Chapter4;

import DataStructures.BinaryNode;
import DataStructures.Queue;
import jdk.incubator.vector.VectorOperators;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    /*
    Given a binary tree, design an algorithm which creates a linked list of all the nodes
    at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
     */

    public static ArrayList<LinkedList> generateDepths(BinaryNode root) {
        //This is essentially like creating a BFS search through a binary tree

        Queue<BinaryNode> q = new Queue<>(root);
        BinaryNode copy = q.remove();
        ArrayList<LinkedList> listOfLLs = new ArrayList<>();
        listOfLLs.add(new LinkedList());
        int counter = 0;
        int powerOfTwo = 0;

        while(copy != null) {
            if(copy.left != null) {
                q.add(copy.left);
            }
            if(copy.right != null) {
                q.add(copy.right);
            }

            if(counter < Math.pow(2, powerOfTwo)) {
                listOfLLs.get(powerOfTwo).add(copy);
                counter++;
            }

            else {
                counter = 0;
                powerOfTwo++;
                listOfLLs.add(new LinkedList());
                listOfLLs.get(powerOfTwo).add(copy);
            }

            copy = q.remove();
        }

        return listOfLLs;
    }
}
