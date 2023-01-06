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
        int numPopped = 0;
        while(!s.isEmpty()) {
            int topItem = s.pop();
            while(!reverseSortedStack.isEmpty() && topItem < reverseSortedStack.peek()) {
                s.push(reverseSortedStack.pop());
                numPopped++;
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

