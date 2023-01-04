package Chapter2;


import DataStructures.*;

public class KthToLast {

    /*
    Implement an algorithm to find the kth to last element of a singly linked list
     */
    public static Object kthToLast(int k, LinkedList<Integer> l) {
        //the difficulty here is since we are given a singly linked list, we cannot start from
        //the end and iterate from the back, since SLLists lack the .prev function.

        Node counter = l.firstNode.next;
        int size = 1;
        while(counter != null) {
            size++;
            counter = counter.next;
        }
        //first we find the size of the list

        counter = l.firstNode.next;

        //once we know the whole size, we can figure out what place from the front k from the back is
        for(int i = 1; i < size - k; i++) {
            counter = counter.next;
        }

        return counter.item;

        //runtime here is O(N) since we have to iterate to the end of the list.
    }

    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            test.addLast(i);
        }
        test.printList();

        System.out.println();
        System.out.print(kthToLast(4, test));
    }
}
