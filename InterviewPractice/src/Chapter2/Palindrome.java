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

    public static boolean isPalindromSLList(Node n) {
        //alternate solution if the given list is SLList. This means our solution of iterating
        //backwards is no longer possible.
        return false;
    }
}
