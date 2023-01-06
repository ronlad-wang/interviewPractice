package Chapter3;

import DataStructures.Stack;

public class SortStack {
    /*
     Write a program to sort a stack such that the smallest items are on the top. You can use
    an additional temporary stack, but you may not copy the elements into any other data structure
    (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
     */

    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> reverseSortedStack = new Stack<>();

        //we're sorting items into the other stack by holding the top item as a variable,
        //then taking items out of the other stack and into the original stack as long as those
        //items are larger than the held item. Then we place the item into the other stack, and
        //replace those items removed back into the other stack (this keeps them in their sorted order)
        //we repeat this process until the original stack is empty, at which point the
        //other stack is sorted in the opposite order.

        //finally, taking each element out of the other stack and placing it in the original stack
        //makes the original stack sorted.

        int numPopped = 0;
        while(!s.isEmpty()) {
            int topItem = s.pop();
            while(!reverseSortedStack.isEmpty() && topItem < reverseSortedStack.peek()) {
                s.push(reverseSortedStack.pop());
                numPopped++;
                //we count the number of times we moved items from the other stack to the original
                //stack so that we know how many we need to replace after the item goes into the
                //correct spot.
            }
            reverseSortedStack.push(topItem);
            for(int i = 0; i < numPopped; i++) {
                reverseSortedStack.push(s.pop());
            }
            numPopped = 0;
        }

        while(!reverseSortedStack.isEmpty()) {
            s.push(reverseSortedStack.pop());
        }

        //runtime is O(N^2) in case we're given a stack that is in the opposite sorted order.
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        for(int i = 0; i < 10; i++) {
            test.push((int) (Math.random() * 10));
        }
        test.printStack();
        System.out.println();
        sortStack(test);
        test.printStack();
    }
}

