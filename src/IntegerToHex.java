public class IntegerToHex {
    String[] digits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();

        if (num < 0) {
            toHexLong(-2L * Integer.MIN_VALUE + num, sb);
        } else {
            toHexLong(num, sb);
        }

        return sb.toString();
    }

    private void toHexLong(long num, StringBuilder sb) {
        if (num < 16) {
            sb.append(digits[(int)num]);
        } else {
            toHexLong(num / 16, sb);
            sb.append(digits[(int)(num % 16)]);
        }
    }

    public static void main(String [] args) {
        IntegerToHex integerToHex = new IntegerToHex();
        int val = 200000;
        System.out.println(val + " in hex is " + integerToHex.toHex(val));
    }
}
