package MiscQuestions;

public class subArraySums {
    /*
    Given an array of ints, find the sum of all elements of all subarrays of that array.
    A subarray is defined as any number of continuous items in the array, from any starting point

    i.e.
    [3, 4, 5]
    has subarrays:
        [3] [4] [5]
        [3, 4] [4, 5]
        [3, 4, 5]
        So total is 9 + 16 + 15 = 40
     */

    public static int findSubArraySums(int[] lst) {
        int total = 0;
        for(int i = 0; i < lst.length; i++) {
            int distanceFromLeft = i + 1;
            int distanceFromRight = lst.length - i;
            int times = 0;
            for(int j = 1; j <= lst.length; j++) {
                times += j;
                if(j > distanceFromLeft) {
                    times -= (j - distanceFromLeft);
                }
                if(j > distanceFromRight) {
                    times -= (j - distanceFromRight);
                }
            }

            total += (times * lst[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(findSubArraySums(new int[]{3, 4, 5}));
        System.out.println(findSubArraySums(new int[]{1, 2, 3, 4, 5}));
    }

}
