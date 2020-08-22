package nipon.coding.practice;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * @author saifulnipo
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-120));
        System.out.println(reverseInteger.reverse(1000000049));
    }

    public int reverse(int x) {
        int reverse = 0, tempReverse = 0, tail;
        while (x != 0) {
            tail = x % 10;
            tempReverse = tempReverse * 10 + tail;

            if ((tempReverse - tail) / 10 != reverse) { // check overflow
                return 0;
            }
            reverse = tempReverse;
            x = x / 10;
        }

        return reverse;
    }
}
