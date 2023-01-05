package Chapter2;

import DataStructures.Node;

public class LoopDetection {
    /*
    Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.
    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points
    to an earlier node, to make a loop in the linked list.
     */


    public static Node loopDetection(Node n1) {
        //wow this one is a doozy
        //the key realization is this - if you have a fast runner moving 2 steps at a time
        //and a slow runner moving 1 step at a time, then if the input loops, eventually slow runner
        //and fast runner will hit each other.

        Node fastRunner = n1.next.next;
        Node slowRunner = n1.next;
        while(fastRunner != slowRunner) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }

        //not only that, once fast runner and slow runner hit each other, the collision point will
        //be k steps away from the beginning of the loop, where k is also the distance
        //from the input node to the beginning of the loop.
        //this is due to some tricky math - say we've taken n steps total. Then fastRunner, f, has taken
        //2n steps and slowRunner, s, has taken n steps. If they've collided, then 2n - k (mod l) = n - k (mod l)
        //where l is the number of steps in the loop.
        //this implies that the collision point is k steps away from the start of the loop.
        //since this is the same distance as the original starting location, we can increment simultaneously
        //from the start and the collision point, and we'll find the start of the loop

        slowRunner = n1;

        while(true) {
            if(slowRunner == fastRunner) {
                return fastRunner;
            }
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
    }

    public static void main(String[] args) {
        Node test1 = new Node(7);
        test1.next = new Node(1);
        test1.next.next = new Node(6);
        test1.next.next.next = new Node(9);
        test1.next.next.next.next = test1.next;
        System.out.println(loopDetection(test1).item);
    }
}
