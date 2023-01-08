package Chapter4;

import DataStructures.BinaryNode;
import DataStructures.Queue;
import jdk.incubator.vector.VectorOperators;

import java.lang.reflect.Array;
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

    public static void createLevelLinkedList(BinaryNode root, ArrayList<LinkedList<BinaryNode>> lists, int level) {
        //this is a way better solution - first of all my solution incorrectly assumes that the given
        //node is complete, when in fact it is not specified, it is just any Binary Node

        //this is a helper function that adds items to the lists ArrayList

        if(root == null) {
            //basecase
            return;
        }

        LinkedList<BinaryNode> list = null;
        if(lists.size() == level) {
            //if we're on a level we've already visited then we have already created a list for said level
            list = new LinkedList<>();
            lists.add(list);
        }
        else {
            //otherwise we need to create a new list
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<BinaryNode>> createLevelLinkedList(BinaryNode root) {
        ArrayList<LinkedList<BinaryNode>> lists = new ArrayList<LinkedList<BinaryNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
}
