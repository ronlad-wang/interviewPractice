package Chapter1;

public class RotateMatrix {
    /*
    Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     */

    public static int[][] rotateMatrix(int[][] m) {
        for(int i = 0; i < m.length/2; i++) {
            //we only iterate halfway through the length of the list because we rotate layer by layer
            //doing so means that we rotate both the left and right sides at once
            //so we only need half the iterations
            for(int j = 0; j < m.length - 2 * i - 1; j++) {
                int temp = m[i][i+j];
                m[i][i+j] = m[m.length - 1 - i  - j][i];
                m[m.length - 1 - i  - j][i] = m[m.length - 1 - i][m.length - i - 1 - j];
                m[m.length - 1 - i][m.length - i - 1 - j] = m[i + j][m.length - 1 - i];
                m[i + j][m.length - 1 - i] = temp;
            }
        }
        return m;
    }

    public static void printMatrix(int[][] m) {
        //helper function to print matrices
        for(int i = m.length - 1; i >= 0; i--) {
            for(int j = m.length - 1; j >= 0; j--) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[5][5];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++) {
                m[i][j] = i + j;
            }
        }

        printMatrix(m);
        System.out.println();
        printMatrix(rotateMatrix(m));
        System.out.println();
        printMatrix(rotateMatrix(m));
        System.out.println();
        printMatrix(rotateMatrix(m));
    }
}
