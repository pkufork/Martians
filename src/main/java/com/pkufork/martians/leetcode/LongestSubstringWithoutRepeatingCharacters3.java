package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/8/1.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] A = new int[s.length()];
        A[0] = 1;
        int max = 1;
        for(int i = 1; i< s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                A[i] = 1;
            }else{
                int j = 1;
                for(; j < A[i-1]+1; j++){
                    if(s.charAt(i) == s.charAt(i-j)){
                        break;
                    }
                }
                A[i] = j;
            }
            if(max < A[i]){
                max = A[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb"));
    }
}
