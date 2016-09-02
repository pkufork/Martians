package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/9/2.
 */
public class L6_ZigZagConversion {
    public String convert(String s, int nRows) {
        int len = s.length();
        if(nRows >= len || nRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< nRows; i++){
            int n = i;
            while(n<len){
                sb.append(s.charAt(n));
                if(i!=0 && i!= nRows-1){
                    n+=(nRows-i-1)<<1;
                    if(n<len){
                        sb.append(s.charAt(n));
                        n+=i<<1;
                    }
                }else{
                    n+=(nRows-1)<<1;
                }
            }
        }
        return sb.toString();
    }

}
