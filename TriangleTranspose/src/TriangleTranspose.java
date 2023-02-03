public class TriangleTranspose {
    /*
    The transpose of a 2D array is a new 2D array whose rows are the columns of the
    original (and vice versa). In a triangular 2D array, you are guaranteed that every
    row has exactly one less element than the row above it. The last row is guaranteed
    to have one element. For example, let A be the 2D array below on the left. The
    transpose of A is the resulting 2D array below on the right.

    Given a triangular 2D array A, non-destructively transpose A
     */

    public static int[][] transposeTriangular(int[][] A) {
        if (A.length == 0) {
            return new int[0][];
        }
        int[][] transpose = new int[A[0].length][];
        for (int i = 0; i < transpose.length; i++) {
            int rowLength = A.length - i;
            transpose[i] = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                transpose[i][j] = A[j][i];
                }
            }
        return transpose;
    }
}
