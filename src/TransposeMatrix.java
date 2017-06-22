import java.util.Arrays;

/**
 * Created by pshetye on 6/17/17.
 */
public class TransposeMatrix {
    public static void transposeMatrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=i+1;j<matrix[i].length;j++) {
                System.out.println("Swapping : " + matrix[i][j] + " & " + matrix[j][i] + " ( i = " + i + " j = " + j + " )");
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;

                System.out.println("during");
                for (int k = 0; k < matrix.length; k++) {
                    System.out.println(Arrays.toString(matrix[k]));
                }
            }
        }
    }

    public static void main(String [] args) {
        int [][] arr = {{1, 0, 1},{1, 0, 1},{1, 0, 1}};
        System.out.println("Before");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        transposeMatrix(arr);

        System.out.println("After");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
