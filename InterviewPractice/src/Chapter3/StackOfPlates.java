package Chapter3;

import DataStructures.Stack;

import java.util.ArrayList;

public class StackOfPlates<T> {
    /*
    Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
    composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
    (that is, pop () should return the same values as it would if there were just a single stack).
    FOLLOW UP
    Implement a function popAt(int index) which performs a pop operation on a specific substack.
     */

    private Stack<T> currStack;
    private ArrayList<Stack<T>> setOfStacks = new ArrayList<>();
    private int currStackSize = 0;
    private int MAX_STACK_SIZE = 10;
    private int currIndexOfStack = 0;

    public StackOfPlates(T item) {
        currStack = new Stack<>(item);
        currStackSize = 1;
        setOfStacks.add(currStack);
    }

    public void push(T item) {
        if(currStackSize == MAX_STACK_SIZE) {
            increaseStackSize(item);
        }
        else {
            currStack.push(item);
        }
    }

    public void increaseStackSize(T item) {
        currIndexOfStack++;
        Stack temp = new Stack(item);
        currStackSize = 1;
        setOfStacks.add(temp);
        currStack = setOfStacks.get(currIndexOfStack);
    }


    public T pop() {
        currStackSize--;
        T temp = currStack.pop();
        if(currStackSize == 0) {
            decreaseStackSize();
        }
        return temp;
    }

    public void decreaseStackSize() {
        setOfStacks.remove(currIndexOfStack);
        currIndexOfStack--;
        currStack = setOfStacks.get(currIndexOfStack);
    }
}
