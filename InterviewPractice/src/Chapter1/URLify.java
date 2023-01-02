package Chapter1;

public class URLify {
    /*
    Write a method to replace all spaces in a string with "%20". You may assume that the string has
    sufficient space at the end to hold all additional characters, and that you are given the "true"
    length of the string. (Note: if implementing in Java, please use a character array so that you can
    perform this operation in place)
    EXAMPLE:
    Input:      "Mr John Smith    ", 13
    Output:     "Mr%20John%20Smith"

    question pg 101
    solution pg 205
     */

    public static String URLify(String s, int trueLength) {
        //Like most string modification problems we iterate from the back to the front
        //This question also asks us to implement an in-place solution, which means we can't
        //use outside data structures, or do things like create a copy of the string

        char[] c = s.toCharArray();
        for(int i = trueLength - 1; i >= 0; i--) {
            if(c[i] == ' ') {
                for(int j = s.length() - 1; j > i + 2; j--) {
                    //this moves all the characters before the space back by two
                    //in order to make space for the new characters
                    c[j] = c[j-2];
                }
                c[i] = '%';
                c[i+1] = '2';
                c[i+2] = '0';
            }
        }

        //runtime of this function has worst case N^2, in the situation where you have a space
        //in between every character. In that case, the internal loop runs at a runtime similar
        //to N-2 + N-4 + N-6 + N-8 +...+ 2 + 0, which works out to O(N^2)
        //the best case is a string with no spaces, in which case we run at Omega(N)
        return String.copyValueOf(c);
    }

    public static String URLifyOptimized(String s, int trueLength) {
        char[] c = s.toCharArray();
        int index = s.length() - 1;
        //introducing the index variable is a really smart change that means we no longer
        //need to iterate backwards when we detect a space
        //instead the index variable keeps track of where we last added a character to the modified
        //char[], and when we detect a ' ', we move forward index by 3

        for(int i = trueLength - 1; i >= 0; i--) {
            if(c[i] == ' ') {
                c[index] = '0';
                c[index - 1] = '2';
                c[index - 2] = '%';
                index = index - 3;
            }
            else {
                c[index] = c[i];
                index--;
            }
        }
        return String.copyValueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(URLifyOptimized("Mr John Smith    ", 13));
    }
}
