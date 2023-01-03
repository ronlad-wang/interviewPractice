package DataStructures;


public class DLLists<T> {

    public Node first;
    public Node currNode;
    public int size = 0;

    public DLLists(T input) {
        first = new Node(input);
        currNode = first;
        size = 1;
    }

    public void add(T input) {
        Node next = new Node(null, currNode, input);
        currNode.next = next;
        currNode = next;
        size++;
    }

    public void printList() {
        Node counter = first;
        for(int i = 0; i < size; i++) {
            System.out.print(counter.item + " ");
            counter = counter.next;
        }
    }
}
