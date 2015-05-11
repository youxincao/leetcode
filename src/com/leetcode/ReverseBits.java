package com.leetcode;

/**
 * Created by weilun on 2015/5/11.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0 ;
        for (int i = 0 ; i < 32 ; i ++ ) {
            int tmp = 0x1 & (n >> i ) ;
            res |= tmp << (31 - i );
        }
        return  res ;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(1));
    }
}
