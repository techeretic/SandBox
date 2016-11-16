import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pshetye on 10/12/16.
 */
public class TwoDArray {
    /**
     *
     Context
     Given a  2D Array, :

     1 1 1 0 0 0
     0 1 0 0 0 0
     1 1 1 0 0 0
     0 0 0 0 0 0
     0 0 0 0 0 0
     0 0 0 0 0 0
     We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

     a b c
     d
     e f g
     There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.

     Task
     Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

     Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

     Input Format

     There are  lines of input, where each line contains  space-separated integers describing 2D Array ; every value in  will be in the inclusive range of  to .

     Constraints

     -9 <= A[i][j] <= 9
      0 <= i, j <= 5

     Output Format

     Print the largest (maximum) hourglass sum found in .

     Sample Input

     1 1 1 0 0 0
     0 1 0 0 0 0
     1 1 1 0 0 0
     0 0 2 4 4 0
     0 0 0 2 0 0
     0 0 1 2 4 0
     Sample Output

     19
     Explanation

     contains the following hourglasses:

     1 1 1   1 1 0   1 0 0   0 0 0
       1       0       0       0
     1 1 1   1 1 0   1 0 0   0 0 0

     0 1 0   1 0 0   0 0 0   0 0 0
       1       1       0       0
     0 0 2   0 2 4   2 4 4   4 4 0

     1 1 1   1 1 0   1 0 0   0 0 0
       0       2       4       4
     0 0 0   0 0 2   0 2 0   2 0 0

     0 0 2   0 2 4   2 4 4   4 4 0
       0       0       2       0
     0 0 1   0 1 2   1 2 4   2 4 0
     The hourglass with the maximum sum () is:

     2 4 4
       2
     1 2 4
     */

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int arr[][] = new int[6][6];
//        for(int arr_i=0; arr_i < 6; arr_i++){
//            for(int arr_j=0; arr_j < 6; arr_j++){
//                arr[arr_i][arr_j] = in.nextInt();
//            }
//        }
        
        int arr[][] =
                {
                        {-1,-1,0,-9,-2,-2},
                        {-2,-1,-6,-8,-2,-5},
                        {-1,-1,-1,-2,-3,-4},
                        {-1,-9,-2,-4,-4,-5},
                        {-7,-3,-3,-2,-9,-9},
                        {-1,-3,-1,-2,-4,-5},
                };
        
        int max = 0;
        for (int i=0; i<4; i++) {
            System.out.println(Arrays.toString(arr[i]));
            for (int j=0;j<4;j++) {
                System.out.println("\n i = " + i + " j = " + j + "\n");
                int sum = arr[j][i] + arr[j][i+1] + arr[j][i+2] +
                        arr[j+1][i+1] +
                        arr[j+2][i] + arr[j+2][i+1] + arr[j+2][i+2];
                System.out.println(arr[i][j] + " + " + arr[i+1][j] + " + "+ arr[i+2][j]);
                System.out.println("  + " + arr[i+1][j+1]);
                System.out.println(arr[i][j+2] + " + " + arr[i+1][j+2] + " + " + arr[i+2][j+2]);

                System.out.println("\n Max = " + max + " Sum = " + sum + "\n");
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.print(max);
    }
}
