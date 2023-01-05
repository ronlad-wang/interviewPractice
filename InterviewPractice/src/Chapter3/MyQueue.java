package Chapter3;

import DataStructures.Stack;

public class MyQueue<T> {
    /*
    Implement a MyQueue class which implements a queue using two stacks.
     */

    public Stack s1 = new Stack();
    public Stack s2 = new Stack();


    public MyQueue() {    }
    public MyQueue(T item) {
        s1.push(item);
    }

    /*
    Key realization is that if you take one stack, and pop repeatedly while placing the popped items
    into another stack, that other stack becomes a queue of the first stack.

    However, because of the way pointers work we can't just do that process once
     */

    public void add(T item) {
        s1.push(item);
    }
    public T remove() {
        moveInto(s1, s2);
        T temp = (T) s2.pop();
        moveInto(s2, s1);
        return temp;
    }
    public T peek() {
        moveInto(s1, s2);
        T temp = (T) s2.peek();
        moveInto(s2, s1);
        return temp;
    }

    public void moveInto(Stack stack1, Stack stack2) {
        //think of this like pouring all the contents of stack1 into stack2
        //if we didn't have this, popping from stack1 would just erase all of our data
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
