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

        public void printNode() {
            Node counter = this;
            while(counter != null) {
                System.out.print(counter.item + " ");
                counter = counter.next;
            }
        }

        public boolean isEqual(Node n) {
            Node temp1 = this;
            while(temp1 != null && n != null) {
                if(temp1.item != n.item) {
                    return false;
                }
                temp1 = temp1.next;
                n = n.next;
            }

            //this last check is to make sure that they are the same size.
            return temp1 == null && n == null;
        }
    }
