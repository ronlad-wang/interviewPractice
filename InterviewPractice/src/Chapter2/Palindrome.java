package Chapter2;

import DataStructures.Node;

public class Palindrome {

    /*
    Implement a function to check if a linked list is a palindrome.
     */

    public static boolean isPalindrome(Node l) {
        //note that this question does not specify whether the linked list is a DLList or a SLList
        //let's assume it's a DLList for simplicity, but in the interview we need to check this

        int length = 0;
        //we added this length variable to same computing time when we iterate through the list

        Node counter = l;
        while(counter.next != null) {
            //the goal is to get a pointer to the end of the list, so we can iterate backwards through
            //the list.
            length++;
            counter = counter.next;
        }

        for(int i = 0; i < length/2; i++) {
            if(counter.item != l.item) {
                return false;
                //if the number is a palindrome, iterating from the front should be
                //the same as iterating from the back
            }
            counter = counter.prev;
            l = l.next;
        }

        return true;

        //runtime here is O(N), since in order to find the size we first have to iterate through
        //the entire list once. Memory is O(1) since we don't need to create any outside data
        //structures.
    }

    public static boolean isPalindromeSLList(Node n) {
        //alternate solution if the given list is SLList. This means our solution of iterating
        //backwards is no longer possible.
        //if we can create a new list that is a reversed copy of N, and that new list is also
        //identical to n, then n must be a palindrome.

        if(n == null) {
            return true;
        }

        //newList will be our reversed order of n
        Node newList = new Node(n.item);
        Node counter = n.next;
        while(counter != null) {
            Node temp = new Node(counter.item);
            temp.next = newList;
            newList = temp;
            counter = counter.next;
        }

        return n.isEqual(newList);
        //isEqual has a runtime of O(N), check the Node class for its implementation
        //note also that we implemented a new function isEqual to solve this, it's way cleaner
        //to delegate tasks like that to new functions as opposed to keeping them all in the same function

        //this new function still has runtime O(N), but it has space O(N) since we need to create
        //a new Linked list.
    }

    public static void main(String[] args) {
        Node test1 = new Node(7);
        test1.next = new Node(1);
        test1.next.next = new Node(6);
        test1.next.next.next = new Node(5);
        test1.next.next.next.next = new Node(6);
        test1.next.next.next.next.next = new Node(1);
        test1.next.next.next.next.next.next = new Node(7);

        System.out.println(isPalindromeSLList(test1));
    }
}
