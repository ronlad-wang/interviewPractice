package DataStructures;


public class LinkedList <T> {
    //Singly Linked List implementation

    //Two sentinel nodes, one for the front and one for the back
    //the front sentinel node is an actual sentinel node, while the back
    //sentinel node is just a pointer to the last node. We can't have an
    //actual back sentinel node since this is a singly linked list.
    public Node firstNode = new Node(null);
    public Node lastNode = firstNode;

    public int size;


    public LinkedList() {}

    public void addFirst(T input) {
        //shifts the rest of the node back by one
        Node restList = firstNode.next;
        firstNode.next = new Node(input, restList);

        //because we don't have a proper back sentinel node, this covers the special case
        //where adding a node to the front of the list causes the lastNode to change
        //this only occurs when the two nodes are on the same Node.
        if(firstNode == lastNode) {
            lastNode = firstNode.next;
        }
        size += 1;
    }
    public T getFirst() {
        if(firstNode.next != null) {
            return (T) firstNode.next.item;
        }
        return null;
    }
    public void removeFirst() {
        if(size == 0) {
            return;
        }
        size -= 1;
        firstNode.next = firstNode.next.next;
    }
    public void addLast(T input) {
        Node temp = new Node(input);
        lastNode.next = temp;
        lastNode = lastNode.next;
        size += 1;

        //there aren't any special cases here since adding to the end of the list
        //will never change the firstNode
    }
    public T getLast() {
        return (T) lastNode.item;
    }
    public void removeLast() {
        if(size == 0) {
            return;
        }
        Node temp = firstNode;

        //in order to find and remove the last node, we need to find the second to last node
        //and make that into the last node. In order to do that we need to traverse from the
        //first node to the second to last node (this is the major weakness of SLLists)
        for(int i = 1; i < size; i++) {
            temp = temp.next;
        }
        temp.next = null;
        lastNode = temp;
        size--;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        if(size == 0) {
            System.out.println("Empty List");
        }
        Node temp = firstNode.next;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
}
