package Chapter5;

public class BinaryToString {
    /*
    Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
    print the binary representation. If the number cannot be represented accurately in binary with at
    most 32 characters, print"ERROR:'
     */

    public static void binaryToString(double num) {
        double powOfTwo = 0.5;
        StringBuilder toString = new StringBuilder(".");
        while(num != 0) {
            if(num > powOfTwo) {
                toString.append('1');
            }
            else {
                toString.append('0');
            }
            powOfTwo /= 2;
            if(toString.length() > 32) {
                System.out.println("error");
                return;
            }
        }
        System.out.println(toString);
    }
}
