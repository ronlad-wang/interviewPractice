package Chapter1;

public class OneAway {
    /*
    There are three types of edits can be performed on strings: insert a character, remove a character,
    or replace a character. Given two strings, write a function to check if they are
    one (or zero) edits away.
     */

    public static boolean isOneAway(String a, String b) {

        //immediately, if the length of the two strings differ by more than 1 then there must have
        //been more than one change
        if(b.length() > a.length() + 1 || b.length() < a.length() - 1) {
            return false;
        }

        //we start by iterating from the front of both strings
        int i = 0;
        boolean hasError = false;
        while(i < a.length() && i < b.length()) {

            //if there is an error, we note that we have found an error and move to the next step
            if(a.charAt(i) != b.charAt(i)) {
                hasError = true;
                break;
            }
            i++;
        }
        if(!hasError) {
            //if we iterated through both strings finding no discrepancies, then there must be at
            //most one error
            //note that this accounts for the case where b is longer than a - if we iterate the length
            //of a and find that b has had no differences, the last value of b is irrelevant, since
            //it is produced by insertion (the one error)
            return true;
        }


        //now we iterate from the end of both strings
        int j = a.length() - 1;
        int k = b.length() - 1;
        while(j > i) {
            if(a.charAt(j) != b.charAt(k)) {
                //if we find a second difference, it must have taken more than one manipulation
                //to produce that error
                return false;
            }
            j--;
            k--;
        }

        //finally we check the remaining special case where b is longer than a
        //this would have caused an error if we had strings like "abc" "adec", where we have
        //one insertion and one change
        if(b.length() > a.length()) {
            //to solve this issue we check if the original error detected was due to an insertion or
            //a change
            return a.charAt(i) == b.charAt(i + 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bae"));
        System.out.println(isOneAway("pale", "pa"));
        System.out.println(isOneAway("pa", "pale"));
    }
}
