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
        /*
        We can solve this question using a fringe. First of all, the first item added must be the root item
        Then, the next item can be any of the children of the first item. We can recursively call
        our function to consider the two cases.

        then, once we have the second item added, the third item can be either the remaining unused root child
        or a child of the second item. We can think of it like the next item can be any of the children
        of any nodes we have already added.

        We implement this using a recursive function
         */

        ArrayList<BinaryNode> fringe = new ArrayList<>();
        fringe.add(root);
        ArrayList<String> allStrings = helperPrint(fringe);


        //our helper function will return an arraylist with every possible string
        for(int i = 0; i < allStrings.size(); i++) {
            System.out.println(allStrings.get(i));
        }
    }

    public static ArrayList<String> helperPrint(ArrayList<BinaryNode> fringe) {
        if(fringe.size() == 0) {
            //base case, if the fringe size is 0 then every single node has been added into
            //the string
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> allPerms = new ArrayList<>();

        for(int i = 0; i < fringe.size(); i++) {
            //our fringe contains all nodes that are children of nodes we have already considered

            BinaryNode tempNode = fringe.get(i);
            ArrayList<BinaryNode> fringeCopy = (ArrayList<BinaryNode>) fringe.clone();
            //we need to create a copy due to funky pointer stuff

            fringeCopy.remove(i);
            //we remove the selected item and add its children to the fringe

            if(tempNode.left != null) {
                fringeCopy.add(tempNode.left);
            }
            if(tempNode.right != null) {
                fringeCopy.add(tempNode.right);
            }

            ArrayList<String> temp = helperPrint(fringeCopy);


            for(int j = 0; j < temp.size(); j++) {
                //all the possible strings are created by getting the current node's item and combining
                //it with the result of the recursive call
                allPerms.add(tempNode.item + " " + temp.get(j));

                //once we have done this with every single node in the fringe we have found all possible
                //strings from this current node and return those strings.
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
