package Chapter1;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
    /*
    Given two strings, write a method to determine if one is a permutation of the other.
    question pg 101
    solution pg 204
     */

    public static boolean isPerm(String a, String b) {
        if(a.length() != b.length()) {
            //immediately, if two strings are of different lengths, they cannot be permutations
            //of each other, so we can save time by instantly marking this as not a permutation
            return false;
        }

        //We can assume we are using ASCII extended for this textbook, though I would check with
        //interviewer before doing so. ASCII has 256 possible characters, so we can store the
        //characters in A and B in arrays of length 256
        //each char in ASCII when converted to an int is a unique number between 0 and 255,
        //so we can use the indices of the arrays to store the number of times each char appears
        //in each word
        int[] charsInA = new int[256];
        int[] charsInB = new int[256];
        //I originally thought to use a HashMap but this way we save some time and space

        for(int i = 0; i < a.length(); i++) {
            //since a and b are the same length we can iterate through both in the same for loop
            charsInA[a.charAt(i)] += 1;
            charsInB[b.charAt(i)] += 1;
        }

        return Arrays.equals(charsInA, charsInB);

        //This solution has runtime O(N) where N is the length of the longer of the two strings
        //It seems impossible to make the runtime any shorter because we need to know every char
        //in each string in order to compare them, which will at minimum require iteration through
        //the String

        //I also considered a solution by sorting each string and comparing them to each other,
        //but the fastest sorting algorithm has runtime O(NlogN), which is slower.
    }

    public static boolean isPermOptimized(String a, String b) {
        //Also good to note that we should've checked to see if things like whitespace
        //or case sensitivity mattered in the question, i.e. if "GOD" is a permutation of "god"
        //or if "       dog" is a permutation of "god".

        if(a.length() != b.length()) {
            return false;
        }

        //key difference in this solution is realizing we don't need to use an extra array to
        //store the characters in B
        int[] charsInA = new int[256];

        for(int i = 0; i < a.length(); i++) {
            charsInA[a.charAt(i)] += 1;
        }

        for(int i = 0; i < b.length(); i++) {
            //this new for loop removes the purpose of a second array
            charsInA[b.charAt(i)] -= 1;
            if(charsInA[b.charAt(i)] < 0) {
                return false;
            }
        }

        //note that we don't need to check to see if there are any leftover characters in the array
        //this is because if the two strings are of equal size, then it is either true that
        //they are a permutation, or at least one value in the charArray will be < 0, in which case
        //we return false.
        return true;
    }

    public static void main(String[] args) {
        //testing
        System.out.println(isPermOptimized("abcdefg", "gfedcba"));
        System.out.println(isPermOptimized("abcdefg", "gfedcbe"));
        System.out.println(isPermOptimized("a lazy brown fox jumped over a 9192348", "9248319 a fox brown jumped over lazy a"));
        System.out.println(isPermOptimized("-+=/.,<>", "+/.,><=-"));
    }
}
