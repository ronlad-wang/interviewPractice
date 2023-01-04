package Chapter2;

import DataStructures.Node;

public class SumLists {
    /*
    You have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the
    head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

    FOLLOW UP:
    Suppose the digits are stored in reverse order, and repeat the question
     */

    public static int sumListsForward(Node<Integer> l1, Node<Integer> l2) {
        int sum = 0;
        int powerOfTen = 1;
        while(l1 != null || l2 != null) {
            //l1 and l2 might be different lengths so these if statements account for that case
            if(l1 != null) {
                sum += l1.item * powerOfTen;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.item * powerOfTen;
                l2 = l2.next;
            }

            powerOfTen *= 10;
        }
        return sum;

        //runtime of this is O(N) where N is the length of the longer list, and memory is O(1)
        //there are other ways to implement the solution, I chose this one because it enables
        //all the code to be written under one loop which is cleaner imo, however, it does cause
        //some ugly looking repeat code.
    }

    public static int sumListsBackward(Node l1, Node l2) {
        //now we want to do the same process but working under the assumption that
        //the listed order of the digits are backwards, i.e. the first digit is first in the node
        //this presents the issue that we don't know what the maximum power of ten will be for each
        //number

        double powerOfTen = 0.1;
        int lengthL1 = 0;
        int lengthL2 = 0;
        int sum = 0;
        double l1Num = 0;
        double l2Num = 0;

        while(l1 != null) {
            //we can flip the order of the numbers in the linked list by dividing and putting them
            //to the left of the decimal point. Then, by finding the length of each number, we know
            //what we need to multiply them by to make them integers.
            lengthL1 += 1;
            l1Num += (double) (int) l1.item * powerOfTen;
            l1 = l1.next;
            powerOfTen = powerOfTen / 10;
        }

        sum = sum + (int) (l1Num * Math.pow(10, lengthL1));
        powerOfTen = 0.1;

        while(l2 != null) {
            lengthL2 += 1;
            l2Num += (double) (int) l2.item * powerOfTen;
            l2 = l2.next;
            powerOfTen = powerOfTen / 10;
        }


        sum = sum + (int) (l2Num * Math.pow(10, lengthL2));
        return sum;

        //runtime is once again O(N) where N is the length of the longest number, and space complexity
        //is also O(1). This code is definitely harder to follow than the previous code, however.
    }

    public static void main(String[] args) {
        Node test1 = new Node(7);
        test1.next = new Node(1);
        test1.next.next = new Node(6);
        test1.next.next.next = new Node(9);

        Node test2 = new Node(5);
        test2.next = new Node(9);
        test2.next.next = new Node(2);

        System.out.println(sumListsBackward(test1, test2));
    }
}
