package Chapter2;

import DataStructures.Node;

public class Intersection {
    /*
    Given two (singly) linked lists, determine if the two lists intersect. Return the
    intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
    kth node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting
     */

    public static Node isIntersecting(Node n1, Node n2) {
        //realize that if two nodes intersect then their last node must be the same

        int length1 = 1;
        int length2 = 1;
        Node counter1 = n1;
        Node counter2 = n2;

        while(counter1.next != null) {
            counter1 = counter1.next;
            length1++;
        }
        while(counter2.next != null) {
            length2++;
            counter2 = counter2.next;
        }
        if(counter1 != counter2) {
            //since counter1 and counter2 are now at the end of the lists,
            //if they are not equal, then the lists must not intersect
            System.out.println("These lists do not intersect");
            return null;
        }

        //if they do intersect, we now need to find where. Because we kept track of the lengths,
        //we can line up the two lists so to speak, and compare the points where we know the intersection
        //could be.


        //first we determine which of the two is longer/shorter
        Node longerList = null;
        Node shorterList = null;

        if(length1 > length2) {
            longerList = n1;
            shorterList = n2;
        }
        else {
            longerList = n2;
            shorterList = n1;
        }

        //then we advance the pointer for the longer of the two until it is in line with the shorter
        for(int i = 0; i < Math.max(length1, length2) - Math.min(length1, length2); i++) {
            longerList = longerList.next;
        }

        //then we find the place of the intersection
        //we can use while(true) because we know an intersection must exist, so eventually this must
        //return a value
        while(true) {
            if(longerList == shorterList) {
                return longerList;
            }
            else {
                longerList = longerList.next;
                shorterList = shorterList.next;
            }
        }
    }


    public static void main(String[] args) {
        Node intersect = new Node(1);
        intersect.next = new Node(2);
        intersect.next.next = new Node(3);

        Node longer = new Node(9);
        longer.next = new Node(10);
        longer.next.next = new Node(11);
        longer.next.next.next = new Node(12);
        longer.next.next.next.next = intersect;

        Node shorter = new Node(7);
        shorter.next = new Node(8);
        shorter.next.next = intersect;

        if(isIntersecting(longer, shorter) != null) {
            isIntersecting(longer, shorter).printNode();
        }
    }
}
