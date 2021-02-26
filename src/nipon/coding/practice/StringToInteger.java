package nipon.coding.practice;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author saifulnipo
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
//        System.out.println(stringToInteger.myAtoi("42"));
//        System.out.println(stringToInteger.myAtoi("++1"));
//        System.out.println(stringToInteger.myAtoi("+-12"));
        System.out.println(stringToInteger.myAtoi("-5-"));
//        System.out.println(stringToInteger.myAtoi("   +   -   12"));
//        System.out.println(stringToInteger.myAtoi("1234"));
//        System.out.println(stringToInteger.myAtoi("-400"));
//        System.out.println(stringToInteger.myAtoi("0012"));
//        System.out.println(stringToInteger.myAtoi("  123"));
//        System.out.println(stringToInteger.myAtoi("12345 hello world"));
//        System.out.println(stringToInteger.myAtoi("hello world  123"));
//        System.out.println(stringToInteger.myAtoi("-91283472332"));
//        System.out.println(stringToInteger.myAtoi("9223372036854775808"));
//        System.out.println(stringToInteger.myAtoi("123.56"));
        System.out.println("0-42a1234 -> " + stringToInteger.myAtoi("0-42a1234"));
        System.out.println("00000-42a1234 -> " + stringToInteger.myAtoi("00000-42a1234"));
//        System.out.println("-  00  12 ->" + stringToInteger.myAtoi("-  00  12"));
//        System.out.println("  00000  +12 -> " + stringToInteger.myAtoi("  00000  +12"));
//        System.out.println(stringToInteger.myAtoi("-  00000  12"));
        System.out.println(stringToInteger.myAtoi("  -0012a42"));
        System.out.println(stringToInteger.myAtoi("  +123"));
        System.out.println(stringToInteger.myAtoi("   +0 123"));
        System.out.println(stringToInteger.myAtoi("-13+8"));
    }

    public int myAtoi(String str) {
        char pre_char = Character.MIN_VALUE;
        long result = 0, finalResult = 0;
        int signedValue = 1;
        for (int i = 0; i < str.length(); i++) {

            char current_char = str.charAt(i);
            if (current_char == ' ' && (pre_char == Character.MIN_VALUE || pre_char == ' ')) {
                pre_char = current_char;
                continue;
            }

            if (isDigit(pre_char) && isSignChar(current_char)) {
                return (int) (signedValue * result);
            }

            if (isSignChar(pre_char) && isSignChar(current_char)) {
                return 0;
            }

            if (isSignChar(current_char)) {
                signedValue = 44 - current_char;
                pre_char = current_char;
                continue;
            }


            if (isDigit(current_char)) {
                result = (result * 10) + getCharIntValue(current_char);
                pre_char = current_char;
            } else {
                return (int) (signedValue * result);
            }
            finalResult = result * signedValue;

            if (finalResult > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (finalResult < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) finalResult;
    }

    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean isSignChar(char c) {
        return c == '+' || c == '-';
    }

    private int getCharIntValue(char c) {
        return c - 48;
    }
}
