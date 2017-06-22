/**
 * Created by pshetye on 6/17/17.
 */
public class ReverseNumber {
    public static void main(String [] args) {
        System.out.println("123 reversed = " + reverseInt(123));
    }

    private static int reverseInt(int x) {
        int num = Math.abs(x);
        int result = 0;
        int maxFactor = -1;
        while(num > 0) {
            num = num/10;
            maxFactor++;
        }
        num = Math.abs(x);
        int multiplier;
        int divider;
        int mod = 0;
        while (num > 0) {
            divider = getPowerOfTen(1);
            multiplier = getPowerOfTen(maxFactor);
            mod = num % divider;
            result += mod * multiplier;
            num = num/10;
            maxFactor--;
        }

        if (x < 0) {
            result *= -1;
        }
        return result;
    }

    private static int getPowerOfTen(int i) {
        if (i < 1) {
            return 1;
        }
        int result = 1;
        for (int j = i-1;j>=0;j--) {
            result *= 10;
        }
        return result;
    }
}
