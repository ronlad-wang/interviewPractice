package Chapter1;

public class PalindromePermutation {
    /*
    Given a string, write a function to check if it is a permutation of a palindrome. A palindrome
    is a word or phrase that is the same forwards or backwards. A permutation is a rearrangement
    of letters. The palindrome does not need to be limited to just dictionary words.

    EXAMPLE:
    input:  Tact Coa
    output: true (example being "taco cat")

    question pg 101
    solution pg 206
     */

    public static boolean isPalindromePermutation(String s) {
        //note: white space does not influence, based on the example provided, whether
        //or not a phrase is a palindrome. So we can safely not consider whitespace when we
        //write our code
        //Make sure to check this with the interviewer

        int[] sChars = new int[256];
        //using the same technique we used in CheckPermutation to store the counts of
        //characters in s

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sChars[Character.toLowerCase(s.charAt(i))]++;
                //the example also shows us that palindromes are not case sensitive, i.e. upper
                // and lower case do not change anything. So we can use toLowerCase to standardize
                //our input
            }
        }


        //there are two cases in which we can create a palindrome.
        //First, if there is an even number of every character, then yes
        //Second, if there is one character that has an odd number and every other character
        //has an even number
        boolean containsOdd = false;
        for(int j = 0; j < 256; j++) {
            if(sChars[j] % 2 == 1) {
                if(containsOdd) {
                    return false;
                }
                containsOdd = true;
            }
        }
        return true;

        //this function has runtime N which should be the fastest possible runtime.
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
