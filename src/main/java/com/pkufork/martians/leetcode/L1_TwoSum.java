package com.pkufork.martians.leetcode;

import java.util.*;

/**
 * Created by pkufork on 16/6/25.
 */
public class L1_TwoSum {
    public int[] twoSum1(final int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(final int[] numbers, int target) {
        List<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < numbers.length ; i++){
            indexes.add(i);
        }
        Collections.sort(indexes, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return numbers[o1]-numbers[o2];
            }
        });
        int i=0,j=numbers.length-1;
        while(i < j){
            int sum = numbers[indexes.get(i)] + numbers[indexes.get(j)];
            if(sum == target){
                break;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        if(i < j){
            int i1 = indexes.get(i);
            int i2 = indexes.get(j);
            return i1< i2? new int[]{i1,i2}:new int[]{i2,i1};
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new L1_TwoSum().twoSum1(new int[]{2,7,11,15}, 9)));
    }
}
