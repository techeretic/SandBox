

/**
 * Created by pshetye on 7/12/16.
 */
public class PowerOfFour {
    private static boolean isPowerOfFour(int num) {
//        System.out.println(num);
//        System.out.println(Math.abs(num));
//        for (;Math.abs(num) > 1;num = num / 4) {
//            System.out.println(num);
//            if (num % 4 > 0) {
//                System.out.println(num);
//                return false;
//            }
//            System.out.println(num);
//        }
        while(num % 4 == 0) {
            num = num / 4;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        System.out.println("-2147483648 - " + isPowerOfFour(-2147483648));
        System.out.println("5 - " + isPowerOfFour(5));
        System.out.println("16 - " + isPowerOfFour(16));
        System.out.println("4096 - " + isPowerOfFour(4096));
        System.out.println(Integer.toString(-2147483648, 4));
        System.out.println(Integer.toString(12, 16));
    }
}
