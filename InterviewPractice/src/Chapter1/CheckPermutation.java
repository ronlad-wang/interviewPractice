package Chapter1;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
    /*
    Given two strings, write a method to determine if one is a permutation of the other.
     */

    public static boolean isPerm(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        int[] charsInA = new int[256];
        int[] charsInB = new int[256];
        for(int i = 0; i < a.length(); i++) {
            charsInA[a.charAt(i)] += 1;
            charsInB[b.charAt(i)] += 1;
        }
        if(Arrays.equals(charsInA, charsInB)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerm("abcdefg", "gfedcba"));
        System.out.println(isPerm("abcdefg", "gfedcbe"));
        System.out.println(isPerm("a lazy brown fox jumped over a 9192348", "9248319 a fox brown jumped over lazy a"));
        System.out.println(isPerm("-+=/.,<>", "+/.,><=-"));
    }
}
