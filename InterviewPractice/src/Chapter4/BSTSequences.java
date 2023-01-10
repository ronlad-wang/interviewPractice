package Chapter4;

import DataStructures.BinaryNode;

import java.util.ArrayList;

public class BSTSequences {

    /*
    A binary search tree was created by traversing through an array from left to right
    and inserting each element. Given a binary search tree with distinct elements, print all possible
    arrays that could have led to this tree
     */

    public static void printBSTSequences(BinaryNode root) {
        ArrayList<BinaryNode> fringe = new ArrayList<>();
        fringe.add(root);
        ArrayList<String> allStrings = helperPrint(fringe);

        for(int i = 0; i < allStrings.size(); i++) {
            System.out.println(allStrings.get(i));
        }
    }

    public static ArrayList<String> helperPrint(ArrayList<BinaryNode> fringe) {
        if(fringe.size() == 0) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> allPerms = new ArrayList<>();

        for(int i = 0; i < fringe.size(); i++) {
            BinaryNode tempNode = fringe.get(i);
            ArrayList<BinaryNode> fringeCopy = (ArrayList<BinaryNode>) fringe.clone();
            fringeCopy.remove(i);

            if(tempNode.left != null) {
                fringeCopy.add(tempNode.left);
            }
            if(tempNode.right != null) {
                fringeCopy.add(tempNode.right);
            }

            ArrayList<String> temp = helperPrint(fringeCopy);
            for(int j = 0; j < temp.size(); j++) {
                allPerms.add(tempNode.item + " " + temp.get(j));
            }
        }
        return allPerms;
    }

    public static void main(String[] args) {
        BinaryNode b1 = new BinaryNode(2);
        BinaryNode b2 = new BinaryNode(1);
        BinaryNode b3 = new BinaryNode(3);
        BinaryNode b4 = new BinaryNode(4);
        b1.left = b2;
        b1.right = b3;
        b3.right = b4;
        printBSTSequences(b1);
    }
}
