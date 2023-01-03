package Chapter1;

public class StringRotation {
    /*
    Assume you have a method is Substring which checks if one word is a substring
    of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
    call to isSubString (e.g., "waterbottle" is a rotation of "erbottlewat")
     */

    public static boolean isRotation(String s1, String s2) {
        //this is a tough one to figure out, but once you do figure it out there isn't much to
        //optimize. the key is to realize that if s2 is a rotation of s1, then s2 must be a substring
        //of s1 + s1. Like in our example, waterbottlewaterbottle contains the substring erbottlewat:
        //wat erbottlewat erbottle.

        String s1s1 = s1 + s1;
        return isSubstring(s2, s1s1);
    }

    public static boolean isRotationOptimized(String s1, String s2) {
        //You can introduce a slight optimization and deal with edge cases by checking to see
        //first if the two strings are of equal length, which is not equal to zero.
        //then we can save space on not storing s1s1.

        if(s1.length() == s2.length() && s1.length() != 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s2, s1s1);
        }
        return false;
    }
}
