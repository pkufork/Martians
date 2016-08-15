package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/8/15.
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int maxi = 0;
        int maxj = 1;
        for (int i = 1; i < s.length()-maxLen/2-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) || s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            int j = 1;
            for (; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++);
            int len = --j * 2 + 1;
            if (len > maxLen) {
                maxLen = len;
                maxi = i - j;
                maxj = i + j + 1;
            }
        }
        for (int i = 0; i < s.length()-maxLen/2;) {
            int j = i;
            for (; j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1); j++);
            if(i != j) {
                int ii = i, jj = j;
                while (ii >= 0 && jj < s.length() && s.charAt(ii) == s.charAt(jj)) {
                    ii--;
                    jj++;
                }
                ii++;
                jj--;
                int len = jj-ii+1;
                if (len > maxLen) {
                    maxLen = len;
                    maxi = ii;
                    maxj = jj + 1;
                }
            }
            i = j + 1;
        }
        return s.substring(maxi, maxj);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring5().longestPalindrome("abbccaaccbb"));
    }
}
