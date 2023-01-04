package Chapter2;
import DataStructures.Node;

public class Partition {
    /*
    Write code to partition a linked list around a value x, such that all nodes less than x come
    before all nodes greater than or equal to x. If x is contained within the list the values of x
    only need to be after the elements less than x (see below). The partition element x can
    appear anywhere in the "right partition"; it does not need to appear between the left and
    right partitions
     */

    public static void partition(Node head, int partition) {
        //this is an in-place solution to this problem

        Node end = head;
        int size = 1;
        while(end.next != null) {
            end = end.next;
            size++;
        }
        //this helps set our system up so that we have a pointer to the end of the list
        //as well as letting us know what the full size of the list is, and therefore how
        //long we need to iterate for.

        Node counter = head;

        //iterate through all items in the list
        for(int i = 0; i < size; i++) {
            if((int) counter.item > partition) {
                //if our current Node has an item greater than the partition we need
                //to do some funky things.

                //We need to make sure that the nodes before and after our current node now
                //have prev and next pointers that point at each other
                if(counter.next != null) {
                    counter.next.prev = counter.prev;
                }
                if(counter.prev != null) {
                    counter.prev.next = counter.next;
                }

                //next we need to move our current node to the end of the list, and set up the
                //current node's previous counter to be the end, the end's next counter to the current node
                //and the current node's next counter to be null.
                //We also need to reset counter and end so that counter is still in the original
                //place in our iteration, and end still points at the last node in the list
                end.next = counter;
                counter.prev = end;
                counter = counter.next;
                end.next.next = null;
                end = end.next;

                //because we moved one node to the end of the list, it's like we have performed
                //one extra iteration
                i++;
            }
            else {
                counter = counter.next;
            }
        }

        //I'm pretty proud of this solution, because it's in-place it looks really weird, but it should
        //still run in O(N) time just like most other solutions
    }

    public static Node partitionOptimized(Node head, int partition) {
        Node h = head;
        Node t = head;
        while(head != null) {
            Node next = head.next;
            if((int) head.item < partition) {
                head.next = h;
                h = head;
            }
            else {
                t.next = head;
                t = head;
            }
            head = next;
        }
        t.next = null;

        return h;
    }
}
