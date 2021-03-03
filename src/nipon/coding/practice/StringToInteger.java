package nipon.coding.practice;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author saifulnipo
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println("42 ->" + stringToInteger.myAtoi("42"));
        System.out.println("++1 ->" +stringToInteger.myAtoi("++1"));
        System.out.println("+-12 ->" + stringToInteger.myAtoi("+-12"));
        System.out.println("-5- ->" +stringToInteger.myAtoi("-5-"));
        System.out.println("   +   -   12 ->" +stringToInteger.myAtoi("   +   -   12"));
        System.out.println("1234 ->" +stringToInteger.myAtoi("1234"));
        System.out.println("-400 ->" +stringToInteger.myAtoi("-400"));
        System.out.println("0012 ->" +stringToInteger.myAtoi("0012"));
        System.out.println("  123 ->" +stringToInteger.myAtoi("  123"));
        System.out.println("12345 hello world ->" +stringToInteger.myAtoi("12345 hello world"));
        System.out.println("hello world  123 ->" +stringToInteger.myAtoi("hello world  123"));
        System.out.println("-91283472332 ->" +stringToInteger.myAtoi("-91283472332"));
        System.out.println("9223372036854775808 ->" +stringToInteger.myAtoi("9223372036854775808"));
        System.out.println("123.56 ->" +stringToInteger.myAtoi("123.56"));
        System.out.println("0-42a1234 -> " + stringToInteger.myAtoi("0-42a1234"));
        System.out.println("00000-42a1234 -> " + stringToInteger.myAtoi("00000-42a1234"));
        System.out.println("-  00  12 ->" + stringToInteger.myAtoi("-  00  12"));
        System.out.println("  00000  +12 -> " + stringToInteger.myAtoi("  00000  +12"));
        System.out.println("-  00000  12 ->" +stringToInteger.myAtoi("-  00000  12"));
        System.out.println("  -0012a42 ->" +stringToInteger.myAtoi("  -0012a42"));
        System.out.println("  +123 ->" +stringToInteger.myAtoi("  +123"));
        System.out.println("   +0 123 ->" +stringToInteger.myAtoi("   +0 123"));
        System.out.println("-13+8 ->" +stringToInteger.myAtoi("-13+8"));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        if (str.equals("-") || str.equals("+")) {
            return 0;
        }

        int startIndex = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            startIndex++;
        }

        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
        }

        double result = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }

            result = result * 10 + Character.getNumericValue(str.charAt(i));
        }

        if (isNegative) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
