public class MultiplyStrings {

    public static void main(String [] args) {
        String num1 = "125";
        String num2 = "5";
        System.out.println(num1 + " x " + num2 + " = " + multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        StringBuilder result = new StringBuilder(num1.length() + num2.length());
        int len = num1.length() + num2.length();
        int carry = 0;
        for (int i = 0; i < len-1; i++) {
            int sum = carry;
            for (int j = 0; j <= i; j++) {
                if (j >= num1.length() || i - j >= num2.length()) {
                    continue;
                }
                sum += (num1.charAt(j) - '0') * (num2.charAt(i-j) - '0');
            }
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
