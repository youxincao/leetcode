package com.leetcode;

/**
 * Created by weilun on 2015/5/11.
 */
public class Robber {
    public int rob1(int [] nums ) {
        if(nums == null || nums.length == 0 )
            return  0;
        return  rob_internal(nums , nums.length);
    }

    private int rob_internal(int[] nums, int length) {
        if( length == 1 )
            return nums[0];
        if( length == 2 )
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int val1 = rob_internal(nums , length - 1 );
        int val2 = rob_internal(nums , length - 2 ) + nums[length - 1 ] ;
        return val1 > val2 ? val1 : val2;
    }


    public int rob(int [] nums) {
        if(nums == null || nums.length == 0 )
            return  0;
        if( nums.length == 1 )
            return nums[0];
        if( nums.length == 2 )
            return nums[0] > nums[1] ? nums[0] : nums[1];

        int [] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            int tmp1 = ans[i - 1 ];
            int tmp2 = ans[i - 2 ] + nums[i];
            ans[i] = tmp1 > tmp2? tmp1 : tmp2;
        }
        return ans[nums.length -1 ];
    }
}
