public class ThreeInOne {
    /*
     Describe how you could use a single array to implement three stacks.
     */

    public static void myAnswer() {
        return;

        /*
        So my immediate thought is to break the array into thirds and keep the head of the stack
        at the beginning of each of those thirds.

        However, you run into the problem where if you have a stack that is too large it crosses
        over into the space of the next stack. And that's pretty bad.

        We can improve this with a trick I learned in CS70 - the bottom of the three stacks
        are at indices 0, 1 and 2 respectively. Then, whenever you push onto the stack, you insert it
        3 away from the previous item. So if we push onto the stack whose bottom is at 0, its next item
        is at 3, then 6, then so on. the other two stacks would go 1 -> 4 -> 7... and 2 -> 5-> 8...

        This way no matter how large one stack is it will not interfere with the other stacks.
        To remove we keep track of the last index (the item at the top of the stack), return the
        item at that index then move the index back by 3 to the next item.
         */
    }
}
