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
            //this question is also slightly unclear, do we get the last value if we ask for the
            //0th from the end or the 1st from the end? Make sure to clarify this.
            //this solution assumes that 1st from the end means the last value.
            counter = counter.next;
        }

        return counter.item;

        //runtime here is O(N) since we have to iterate to the end of the list.
    }

    public static Object kthToLastSlightOptimization(int k, LinkedList<Integer> l) {

        //this solution uses the two runner system to solve the question in a slightly more
        //optimal fashion. It is still O(N) time, but now removes the need to perform a second
        //iteration through the list.


        Node fastRunner = l.firstNode.next;
        Node slowRunner = l.firstNode.next;


        for(int i = 0; i < k; i++) {
            fastRunner = fastRunner.next;
        }
        //realize that since fastrunner is now k nodes ahead of slowrunner, it will reach the end
        //at the same time that slowrunner reaches the kth node from the end.

        while(fastRunner != null) {
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }

        return slowRunner.item;
    }

    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            test.addLast(i);
        }
        test.printList();

        System.out.println();
        System.out.print(kthToLastSlightOptimization(3, test));
    }
}
