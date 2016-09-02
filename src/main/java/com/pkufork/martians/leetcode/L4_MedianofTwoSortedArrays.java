package com.pkufork.martians.leetcode;

/**
 * Created by pkufork on 16/8/9.
 */
public class L4_MedianofTwoSortedArrays {
    private int findNthSortedArrays(int A[], int as, int B[], int bs, int n){
        while(n>1 && as < A.length && bs < B.length){
            int half = n/2;
            if(as + half > A.length){
                half = A.length - as;
            }
            if(bs + half > B.length){
                half = B.length - bs;
            }
            if(A[as+half-1] > B[bs+half-1]){
                bs = bs + half;
            }else{
                as = as + half;
            }
            n = n - half;
        }
        if(as >= A.length){
            return B[bs + n-1];
        }else if(bs >= B.length){
            return A[as+n-1];
        }
        return A[as]>B[bs]?B[bs]:A[as];
    }


    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length+B.length;
        if(len%2 == 0){
            int m1 = findNthSortedArrays(A, 0, B, 0, len/2);
            int m2 = findNthSortedArrays(A, 0, B, 0, len/2+1);
            return ((double)m1+m2)/2;
        }else{
            return findNthSortedArrays(A, 0, B, 0, len/2+1);
        }
    }

    public static void main(String[] args){
        int[] A = {1,2,3};
        int[] B = {1};
        System.out.println(new L4_MedianofTwoSortedArrays().findMedianSortedArrays(A, B));
    }
}
