/**
 * Created by pshetye on 7/13/16.
 */
public class Queens {

    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     ***************************************************************************/
    public static boolean isConsistent(int[] q, int k) {
        for (int i = 0; i < k; i++) {
            if (q[i] == q[k]) {
                return false;   // same column
            }
            if (Math.abs(q[i] - q[k]) == (k - i)) {
                return false;
            }
        }
        return true;
    }


    /***************************************************************************
     *  Try all permutations using backtracking
     ***************************************************************************/
    public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) {
            printQueens(q);
        }
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) {
                    enumerate(q, k+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        enumerate(8);
    }

    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     ***************************************************************************/
    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
