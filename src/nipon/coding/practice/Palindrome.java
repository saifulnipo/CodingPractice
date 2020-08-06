package nipon.coding.practice;

/**
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author saifulnipo
 */
public class Palindrome {

    public static void main(String[] args) {
        Palindrome longestSubstring = new Palindrome();
        System.out.println(longestSubstring.longestPalindrome("abba is a racecar"));
        System.out.println(longestSubstring.longestPalindrome("abba is a foo"));
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0, len, len1, len2;

        for (int i = 0; i < s.length(); i++) {
            len1 = expandFromMiddle(s, i, i);
            len2 = expandFromMiddle(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
