package nipon.coding.practice;

import java.util.HashMap;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author saifulnipo
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("au"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("  a   b "));
        System.out.println(longestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(longestSubstring.lengthOfLongestSubstring(""));
        System.out.println(longestSubstring.lengthOfLongestSubstring("a"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("anviaj"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, length, strLength = s.length();
        HashMap<Character, Integer> uniqueCharList = new HashMap<>();
        for (int i = 0; i < strLength; i++) {
            length = 1;
            for (int j = i + 1; j < strLength; j++) {
                if (s.charAt(i) != s.charAt(j) && !uniqueCharList.containsKey(s.charAt(j))) {
                    uniqueCharList.put(s.charAt(j), 1);
                    length++;
                } else {
                    uniqueCharList.clear();
                    break;
                }
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
