package DataStructures;

public class BinaryNode {
    public int item;
    public BinaryNode left;
    public BinaryNode right;
    public BinaryNode parent;

    public BinaryNode(int i) {
        item = i;
    }

    public void printTree() {

        if(left != null) {
            left.printTree();
        }
        System.out.print(item + " ");
        if(right!= null) {
            right.printTree();
        }
    }
}
