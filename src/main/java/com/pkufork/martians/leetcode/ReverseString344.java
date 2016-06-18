package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/6/18.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public void reverseStringInPlace(StringBuilder sb) {
        reverseStringInPlace(sb, 0, sb.length() - 1);
    }

    public void reverseStringInPlace(StringBuilder sb, int start, int end) {
        if (start >= end || end > sb.length() - 1) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
    }

    public void reverseSentenceInPlace(StringBuilder sb) {
        int i = 0, j = 0;
        for (; j < sb.length(); j++) {
            if (!Character.isLetter(sb.charAt(j))) {
                if (i < j) {
                    reverseStringInPlace(sb, i, j - 1);
                }
                i = j;
                i++;
            }
        }
        if (i < j) {
            reverseStringInPlace(sb, i, j - 1);
        }
        reverseStringInPlace(sb, 0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString344().reverseString(""));
        StringBuilder sb = new StringBuilder("hello, , world!");
        new ReverseString344().reverseSentenceInPlace(sb);
        System.out.println(sb);
    }
}
