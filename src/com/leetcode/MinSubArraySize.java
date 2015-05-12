package com.leetcode;

/**
 * Created by weilun on 2015/5/12.
 */
public class MinSubArraySize {

    public int minSubArrayLen(int s, int[] nums) {

        if (null == nums || nums.length == 0)
            return 0;
        int size = 0;
        int begin = 0;
        int end = 0;
        int cur_sum = 0;

        for (int i = 0; i < nums.length; i++) {
           if( cur_sum < s) {
               cur_sum += nums[i];
               size += 1 ;
               end = i ;
           }else {
               if( nums[i] > nums[begin] ) {

               }
           }
        }

        if (cur_sum < s)
            return 0;
        else
            return size;

    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int s = 9;

        MinSubArraySize msas = new MinSubArraySize();
        msas.minSubArrayLen(s, test1);
    }
}
