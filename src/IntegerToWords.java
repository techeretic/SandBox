import java.util.HashMap;
import java.util.Map;

public class IntegerToWords {
    private static Map<Integer, String> dictionary = new HashMap<>();

    static {
        dictionary.put(1, "One");
        dictionary.put(2, "Two");
        dictionary.put(3, "Three");
        dictionary.put(4, "Four");
        dictionary.put(5, "Five");
        dictionary.put(6, "Six");
        dictionary.put(7, "Seven");
        dictionary.put(8, "Eight");
        dictionary.put(9, "Nine");
        dictionary.put(10, "Ten");
        dictionary.put(11, "Eleven");
        dictionary.put(12, "Twelve");
        dictionary.put(13, "Thirteen");
        dictionary.put(14, "Fourteen");
        dictionary.put(15, "Fifteen");
        dictionary.put(16, "Sixteen");
        dictionary.put(17, "Seventeen");
        dictionary.put(18, "Eighteen");
        dictionary.put(19, "Nineteen");
        dictionary.put(20, "Twenty");
        dictionary.put(30, "Thirty");
        dictionary.put(40, "Forty");
        dictionary.put(50, "Fifty");
        dictionary.put(60, "Sixty");
        dictionary.put(70, "Seventy");
        dictionary.put(80, "Eighty");
        dictionary.put(90, "Ninety");
    }

    private static final String hundredText = "Hundred";
    private static final String thousandText = "Thousand";
    private static final String millionText = "Million";
    private static final String billionText = "Billion";

    private static final int oneBillion = 1000000000;
    private static final int oneMillion = 1000000;
    private static final int oneThousand = 1000;

    private void parseTwos(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            sb.append(dictionary.get(num));
        } else {
            int tenner = num / 10;
            int remainder = num - (tenner * 10);

            sb.append(dictionary.get(tenner * 10)).append(" ");

            if (remainder > 0) {
                sb.append(dictionary.get(remainder)).append(" ");
            }
        }
    }

    private void parseThrees(int num, StringBuilder sb) {
        int hundred = num/100;

        int remainder = num - (hundred * 100);

        if ((hundred * remainder) > 0) {
            sb.append(dictionary.get(hundred)).append(" ").append(hundredText).append(" ");
            parseTwos(remainder, sb);
        } else if (hundred == 0 && remainder > 0) {
            parseTwos(remainder, sb);
        } else {
            sb.append(dictionary.get(hundred)).append(" ").append(hundredText).append(" ");
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int billion = num / oneBillion;
        int million = (num - (billion * oneBillion)) / oneMillion;
        int thousand = (num - (billion * oneBillion) - (million * oneMillion)) / oneThousand;
        int remainder = (num - (billion * oneBillion) - (million * oneMillion) - (thousand * oneThousand));

        StringBuilder sb = new StringBuilder();

        if (billion > 0) {
            parseThrees(billion, sb);
            sb.append(" ").append(billionText).append(" ");
        }

        if (million > 0) {
            parseThrees(million, sb);
            sb.append(" ").append(millionText).append(" ");
        }

        if (thousand > 0) {
            parseThrees(thousand, sb);
            sb.append(" ").append(thousandText).append(" ");
        }

        if (remainder > 0) {
            parseThrees(remainder, sb);
        }

        String result = sb.toString();

        sb = new StringBuilder();

        for (int i = 0; i < result.length(); i++) {
            if (i > 0 && result.charAt(i) == ' ' && result.charAt(i - 1) == ' ') {
                continue;
            }

            if (i == result.length() - 1 && result.charAt(i) == ' ') {
                continue;
            }
            sb.append(result.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String [] args) {
        IntegerToWords integerToWords = new IntegerToWords();
        int integer = 1100;
        System.out.println(integer + " in words " + integerToWords.numberToWords(integer));
    }
}
