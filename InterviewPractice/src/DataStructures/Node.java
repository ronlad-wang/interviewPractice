package DataStructures;

public class Node<T> {
        //note the prev Node, which allows us to connect backwards from the ending sentinel node
        public T item;
        public Node next;
        public Node prev;

        public Node() {}
        public Node(T i) {
            item = i;
        }
        public Node(Node n, Node p, T i) {
            item = i;
            next = n;
            prev = p;
        }
        public Node(T input, Node n) {
            item = input;
            next = n;
        }
    }
