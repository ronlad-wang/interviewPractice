package Chapter1;

import java.util.ArrayList;
import java.util.HashMap;

public class IsUnique {
    /*
    Implement an algorithm to determine if a string is all unique characters.
    What if you cannot use additional data structures?
    question pg 101
    solution pg 203
     */

    public static boolean isUniqueDS(String s) {
        //we use an ArrayList to keep track of all the characters we've currently found
        ArrayList<String> foundChar= new ArrayList<>();

        if(s.length() > 256) {
            //we make this check since there are only 256 unique characters in the ASCII extended
            //vocabulary, so if our string is greater than that in length it cannot be all unique
            return false;
        }

        //we iterate through every character in s using the substring command
        for(int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            if(foundChar.contains(String.valueOf(currLetter))) {
                return false;
            }
            else {
                foundChar.add(String.valueOf(currLetter));
            }
        }
        return true;

        //this function has runtime O(N), where N is the length of the string
        //this is the fastest the function can run because by definition, to test
        //if each character in the string is unique, you will need to evaluate
        //each character, which will necessitate, at minimum, iterating through each char in the string
    }

    public static boolean isUniqueNoDS(String s) {
        //we can't use outside data structures so we have no way to store the characters we've already
        //seen
        for(int i = 0; i < s.length(); i++) {
            String currLetter = s.substring(i, i+1);

            for(int j = i+1; j < s.length(); j++) {
                //we can set j = i+1 because previously we must have checked that the characters at
                //i-1, i-2 ..., 0, are not equal to other characters later in s in order to have
                //gotten to this point
                String compareLetter = s.substring(j, j+1);
                if(currLetter.equals(compareLetter)) {
                    return false;
                }
            }
        }
        return true;

        //this solution has runtime O(N^2). We could have a faster solution by using a sorting algorithm
        //but that would require higher space complexity, and this is less a sorting question
        //than a String question.
    }

    public static void main(String[] args) {
        System.out.println(isUniqueDS("asdbkna"));
        System.out.println(isUniqueNoDS("asdbkna"));
    }
}
