package DataStructures;

public class Queue<T> {
    private class QueueNode<T> {
        //essentially a SLList node
        private T item;
        private QueueNode next;

        public QueueNode(T i) {
            item = i;
        }

        public void setNext(QueueNode n) {
            next = n;
        }

        public QueueNode getNext() {
            return next;
        }

        public T getItem() {
            return item;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public Queue(T i) {
        first = new QueueNode(i);
        last = first;
    }

    public void add(T i) {
        last.setNext(new QueueNode(i));
        last = last.getNext();
    }

    public T remove() {
        T temp = (T) first.getItem();
        first = first.getNext();
        return temp;
    }

    public T peek() {
        return (T) first.getItem();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void printList() {
        QueueNode temp = first;
        while(temp != null) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

}
