/**
 * Created by pshetye on 7/13/16.
 */
public class Zeroes {
    private static int countNumZeroes(int[][] matrix) {
        int row = matrix.length - 1, col = 0, numZeroes = 0;
        while (col < matrix[0].length) {
            while (matrix[row][col] != 0) {
                if (--row < 0) {
                    return numZeroes;
                }
            }
            // Add one since matrix index is 0 based
            numZeroes += row + 1;
            col++;
        }
        return numZeroes;
    }

    public static void main(String [] args) throws Exception {
        int [][] mat = {
                {0,0,0,0},
                {0,0,1,1},
                {0,1,1,1},
                {1,1,1,1}
        };
        System.out.println(countNumZeroes(mat));
    }
}
