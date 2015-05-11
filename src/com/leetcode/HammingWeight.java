package com.leetcode;

/**
 * Created by weilun on 2015/5/11.
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int res = 0 ;
        for (int i = 0 ; i < 32 ; i ++ ) {
            int tmp = 0x1 & (n >> i ) ;
            res += tmp;
        }
        return  res ;
    }

    public static void main(String[] args) {
        HammingWeight hw = new HammingWeight();
        System.out.println(hw.hammingWeight(11));
    }
}
