/**
 * Created by pshetye on 7/17/17.
 */
public class LicenceKey {
    private static final String DASH = "-";

    public static void main(String [] args) {
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 2));
        System.out.println(licenseKeyFormatting("r", 1));
    }

    public static String licenseKeyFormatting(String S, int k) {
        String s = S.replaceAll(DASH, "").toUpperCase();
        int len = s.length();
        int first = 0;
        if (len % k != 0) {
            first = len % k;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int d = first > 0 ? first : k;
            if ((i + 1) % d == 0) {
                sb.append(s.substring(i - d + 1, i + 1));
                if ((i + 1) < s.length()) {
                    sb.append(DASH);
                }
            }
        }
        return sb.toString();
    }
}
