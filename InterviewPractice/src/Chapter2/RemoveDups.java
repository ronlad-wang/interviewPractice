package Chapter2;


import DataStructures.DLLists;
import DataStructures.Node;

import java.util.ArrayList;

public class RemoveDups {
    /*
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
     */

    public static DLLists<Integer> removeDupsBuffer(DLLists<Integer> l) {
        //if we can use a temporary buffer the question is greatly simplified because we can
        //store the values which we have already seen

        ArrayList<Integer> a = new ArrayList<>();
        //this arrayList stores the values which we have already seen

        Node counter = l.first;

        //the size manipulation is due to the way we implemented printList for testing DLLists.
        //in an interview we wouldn't have to deal with this
        int size = l.size;

        for(int i = 0; i < size; i++) {
            if(a.contains(counter.item)) {

                counter.prev.next = counter.next;

                //we need this if statement to catch the special cases where the counter is the
                //last node, in which case counter.next cannot be accessed. We don't need to check
                //this for counter.prev = null, since that only happens when counter is the first node
                //and we can never have a duplicate when counter is the first node.
                if(counter.next != null) {
                    counter.next.prev = counter.prev;
                }

                //we need to update size to make our tests work, this is unecessary in an interview
                l.size--;
            }
            else {
                a.add((Integer) counter.item);
            }
            counter = counter.next;
        }

        return l;

        //Runtime of this function is O(N), since it requires you to iterate through the whole
        //DLList. Its memory is also O(N) since we need to store the seen values in an arraylist
        //that can at max become the same size as the original list.
    }

    public static DLLists<Integer> removeDupsNoBuffer(DLLists<Integer> l) {
        //this solution doesn't use an internal buffer to store the items we've already seen

        int originalSize = l.size;

        //place is a second runner
        int place = 0;
        Node counter = l.first;


        for(int i = 0; i < originalSize; i++) {

            //these lines check to see if the current item is a duplicate
            boolean isDuplicate = false;
            Node internalCounter = l.first;

            //place is an internal runner - it doesn't increase by 1 when we remove an item
            //since if the item has been removed it's like we're checking one item further
            //in the list already
            for(int j = 0; j < place; j++) {
                if(internalCounter.item == counter.item) {
                    isDuplicate = true;
                    break;
                }
                internalCounter = internalCounter.next;
            }

            if(isDuplicate) {
                //if we've found a duplicate we simply remove it from l on the spot
                l.size--;
                counter.prev.next = counter.next;

                if(counter.next != null) {
                    counter.next.prev = counter.prev;
                }
            }
            else {
                place++;
            }

            counter = counter.next;
        }

        return l;

        //in worst case this has runtime O(N^2) because it might have no duplicates
        //in which case running the duplicate checking takes 1 + 2 + ... + N work, which is
        //N^2. However, this requires O(1) space complexity since we don't create any data structures
        //to store visited nodes.
    }

    public static void main(String[] args) {
        DLLists<Integer> test = new DLLists<>(1);
        for(int i = 2; i < 10; i++) {
            test.add((int)(Math.random() * 10));
        }
        test.printList();
        System.out.println();
        removeDupsBuffer(test).printList();

        System.out.println();
        System.out.println();

        test = new DLLists<>(1);
        for(int i = 2; i < 10; i++) {
            test.add((int)(Math.random() * 10));
        }
        test.printList();
        System.out.println();
        removeDupsNoBuffer(test).printList();
    }
}
