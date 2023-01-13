package Chapter5;

public class BinaryToString {
    /*
    Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
    print the binary representation. If the number cannot be represented accurately in binary with at
    most 32 characters, print"ERROR:'
     */

    public static void binaryToString(double num) {
        int count = 0;
        double powOfTwo = 0.5;
        String toString = "0.";
        while(num != 0) {
            if(num > powOfTwo) {
                toString += "1";
            }
            else {
                toString += "0";
            }
            powOfTwo /= 2;
            count++;
            if(count > 32) {
                System.out.println("error");
                return;
            }
        }
        System.out.println(toString);
    }
}
