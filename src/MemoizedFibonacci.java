public class MemoizedFibonacci {
    public static void main(String [] args) {
        System.out.println("\n\n10th Fib = " + nthFib(10));
    }

    private static int nthFib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int l = 0, r = 1;
        int fn = l + r;
        System.out.print("0 1 ");

        for (int i = 2; i < n; i++) {
            fn = l + r;
            System.out.print(fn + " ");
            l = r;
            r = fn;
        }

        return fn;
    }
}
