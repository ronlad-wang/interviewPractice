package MiscQuestions;

import java.util.List;

public class kSubarrays {
    /*
    A k-subarray is a subarray whose contents are divisible by k.
    Given an int array and a number k, find the number of k subarrays in that array.
     */

    public static long kSub(int k, List<Integer> nums) {
        long numKArrays = 0;
        //keeps track of the number of solutions we've found

        int[] prev = new int[k];
        //the key realization is we can find the kinds of k-arrays we can produce
        //at index i by knowing the kinds of k-arrays we can produce at index
        //i - 1. For example, say we have k = 5, and at i-1, we have 1 way to
        //make a 1-subarray, 2 ways to make a 3-subarray and 1 way to make a
        //4-subarray. We can represent this in an array of length k.
        //[0, 1, 0, 2, 1]
        //then if we know the value at i mod k, we can find
        //the number of ways we can make new subarrays. i.e. if i mod k = 1, then
        //we will now have 1 way to make a 2-subarray, 2 ways to make a 4-subarray
        //and 1 way to make a 0-subarray. In addition, we consider the case
        //where our subarray contains only i, which gives us 1 way to make a
        //1-subarray
        //[1, 1, 1, 0, 4]
        //From here, we know that the number of k-subarrays we could've made is
        //equal to the number at index 0, which we can collect and sum up as
        //our return value. By iterating through the array while knowing the
        //prev array we can count the number of k-subarrays in O(k * N), where
        //N is the length of nums.

        for(int i = 0; i < nums.size(); i++) {
            int[] curr = new int[k];
            for(int j = 0; j < prev.length; j++) {
                if(prev[j] != 0) {
                    curr[(j + nums.get(i)) % k] += prev[j];
                }
            }
            curr[nums.get(i) % k]++;
            numKArrays += curr[0];
            prev = curr;
        }
        return numKArrays;
    }
}
