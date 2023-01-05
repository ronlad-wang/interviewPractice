package DataStructures;

public class Stack<T> {
    private class StackNode<T> {
        //essentially a SLList node
        private T item;
        private StackNode under;

        public StackNode(T i) {
            item = i;
        }

        public void setUnder(StackNode n) {
            under = n;
        }

        public StackNode getUnder() {
            return under;
        }

        public T getItem() {
            return item;
        }
    }

    private StackNode top;


    public Stack(T i) {
        top = new StackNode(i);
    }

    public void push(T i) {
        StackNode temp = new StackNode(i);
        temp.setUnder(top);
        top = temp;
    }

    public T peek() {
        return (T) top.getItem();
    }

    public T pop() {
        StackNode temp = top;
        top = top.getUnder();
        return (T) temp.getItem();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        StackNode temp = top;
        System.out.println("top -> bottom");
        while(temp != null) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getUnder();
        }
        System.out.println();
    }
}
