package Chapter3;

public class StackMin {
    /*
    How would you design a stack which, in addition to push and pop, has a function min
    which returns the minimum element? Push, pop and min should all operate in 0(1) time
     */

    public static void mySolution() {
        /*
        In order to return the min we need to keep track of what the min is at any given time
        we can do this by creating an instance variable like int min, which is updated every time
        we push onto the stack. We check if the new pushed item is smaller than the original item
        then we update the min if necessary.

        Then we run into an issue of what happens if we remove the smallest item. There's also a special
        case where there are duplicate copies of the smallest item in the stack. In order to deal with
        the special case, min needs to be a pointer to the smallest item, not just a copy of it.
        This is so when we remove that Node we can tell that we have removed the min.

        How do we update the min when we remove it though?
        My original thought was to make min a priority queue, with priority based on the size of the
        item stored in the Node. This would allow us to remove the minimum easily. However, this runs
        into an issue where removing an item from the queue that isn't the smallest requires runtime
        O(N), which screws up push()

        Instead I think the solution is actually to update min every time we remove the smallest by
        scanning the entire stack and finding the smallest Node within it.
        This may seem like it has a runtime of O(N), and in the worst case it does. However, I think
        this has amortized runtime of O(N). If we assume the smallest item is halfway through the Stack
        (as it will be on average), then we can remove N/2 in constant time. The resizing then takes
        N/2 time. Then, if the next smallest is once again the middle, we can remove N/4 in constant time
        And the resizing will take N/4 time. This pattern continues, eventually showing us that we can
        perform N removals in N time, which averages out to O(1) time for each removal

        Pseudocode:
        (added to the Stack Data Structure)

        private StackNode min;

        public Stack(T item) {
            ...

            min = first;
            //In addition to initializing the first Node we also need to set this Node as the
            //smallest Node.
        }

        public push(T item) {
            ...
            if(item < min.item) {
                set the new Node as the min
            }
        }

        public pop() {
            if(poppedNode == min) {
                findMin();
            }
        }

        public void findMin() {
            Node copy = first;
            Node tempMin = first;
            while(copy != null) {
                if(copy.item < tempMin.item) {
                    tempMin = copy;
                }
                copy = copy.under;
            }
        }
         */
    }

    public void bookSolution() {
        /*
        The book solution considers the same solution I do but doesn't seem to take into amortized
        runtime, so I presume something must be wrong about that solution.

        However, it proposes a smart idea to update the individual nodes of the stack to keep
        track of an int, the minimum of the stack beneath it. When we add nodes, we update
        this value, by comparing the node's value and the minimum of the node beneath it, then
        selecting whichever is smaller.

        Returning the min is simple because we just return the min value of whatever node
        is at the top of the stack.
         */
    }
}
