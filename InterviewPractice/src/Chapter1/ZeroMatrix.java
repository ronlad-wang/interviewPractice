package Chapter1;
import java.lang.Math.*;

public class ZeroMatrix {
    /*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to 0.
     */

    public static int[][] zero(int[][] m) {
        //the main difficulty with this question is figuring out how to optimize space
        //we do so by creating two int arrays to keep track of the rows/columns that contain
        //0s, then setting those rows and columns to 0 in the actual matrix

        int[] columnsWith0 = new int[m.length];
        int[] rowsWith0 = new int[m[1].length];
        int numZeroes = 0;
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[1].length; j++) {
                if(m[i][j] == 0) {
                    if(!contains(columnsWith0, i + 1)) {
                        columnsWith0[numZeroes] = i + 1;
                    }
                    if(!contains(rowsWith0, j + 1)) {
                        rowsWith0[numZeroes] = j + 1;
                    }
                    numZeroes++;
                }
            }
        }

        for(int i = 0; i < columnsWith0.length; i++) {
            if(columnsWith0[i] != 0) {
                for(int j = 0; j < m[1].length; j++) {
                    m[columnsWith0[i] - 1][j] = 0;
                }
            }
        }
        for(int i = 0; i < rowsWith0.length; i++) {
            if(rowsWith0[i] != 0) {
                for(int j = 0; j < m.length; j++) {
                    m[j][rowsWith0[i] - 1] = 0;
                }
            }
        }

        return m;
    }

    public static boolean contains(int[] a, int find) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == find) {
                return true;
            }
        }
        return false;
    }

    public static void printMatrix(int[][] m) {
        //helper function to print matrices
        for(int i = m.length - 1; i >= 0; i--) {
            for(int j = m[1].length - 1; j >= 0; j--) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] zeroOptimized(int[][] m) {
        //in the space optimized solution instead of creating a new array for the rows and columns
        //that contain 0, we can instead use the first row and first column to store which rows/columns
        //have zeroes. This solution makes it so that our space complexity is 1, since everything is
        //in place.

        //however, it does run into a few issues because now we need to perform a separate check to see
        //if the first row and column have 0 in them, since we are storing 0s in those columns, so
        //we can no longer check them at the end to know if they have 0s. This leads to a lot of
        //repeated code.

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[1].length; j++) {
                if(m[i][j] == 0) {
                    if(i == 0) {
                        firstColumnHasZero = true;
                    }
                    if(j == 0) {
                        firstColumnHasZero = true;
                    }
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }
        System.out.println();
        printMatrix(m);
        System.out.println();

        for(int i = 1; i < m.length; i++) {
            if(m[i][0] == 0) {
                for(int j = 0; j < m[1].length; j++) {
                    m[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < m[0].length; i++) {
            if(m[0][i] == 0) {
                for(int j = 0; j < m.length; j++) {
                    m[j][i] = 0;
                }
            }
        }

        if(firstColumnHasZero) {
            for(int j = 0; j < m.length; j++) {
                m[0][j] = 0;
            }
        }
        if(firstRowHasZero) {
            for(int j = 0; j < m.length; j++) {
                m[j][0] = 0;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        int[][] m = new int[5][6];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
                m[i][j] = (int) (Math.random() * 10);
            }
        }

        printMatrix(m);
        System.out.println();
        printMatrix(zeroOptimized(m));
    }
}
