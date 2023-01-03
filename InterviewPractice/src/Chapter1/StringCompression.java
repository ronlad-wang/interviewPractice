package Chapter1;

public class StringCompression {
    /*
    Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     */

    public static String compress(String s) {

        //using a StringBuilder is great for this question because appending to a StringBuilder
        //runs in O(1) time, whereas copying Strings can be more complicated
        StringBuilder compressedS = new StringBuilder();

        //this is essentially a sentinel node for our StringBuilder. We're given in the question
        //that the input string only contains upper and lowercase letters.
        char currChar = '!';
        int currCount = 0;


        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != currChar) {
                //the question is unclear on case sensitivity, i.e. should we compress a and A together
                compressedS.append(currChar).append(currCount);
                currChar = s.charAt(i);
                currCount = 1;
            }
            else {
                currCount++;
            }
        }
        //we need to add a final appends at the end here in order to catch the last set of
        //characters
        compressedS.append(currChar).append(currCount);

        if(compressedS.toString().length() - 2 >= s.length()) {
            //note that we have to subtract 2 in order to get rid of our sentinel node
            return s;
        }
        else {
            //once again we're getting rid of the sentinel node
            return compressedS.toString().substring(2);
        }

        //runtime of this is N, since we have a for loop that iterates through the whole word once
        //this is the fastest asymptotic runtime we can get.
    }

    public static void main(String[] args) {
        System.out.println(compress("aabccccaaa"));
        System.out.println(compress("abca"));
        System.out.println(compress("aabbccaa"));
    }
}
