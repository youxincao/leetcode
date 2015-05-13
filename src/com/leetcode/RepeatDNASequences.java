package com.leetcode;

import java.util.*;

/**
 * Created by weilun on 2015/5/12.
 */
public class RepeatDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null)
            return null;

        List<String> ans = new ArrayList<>();
        int count = s.length() - 10;
        Set<Integer> set = new HashSet<>();


        for (int i = 0; i <= count; i++) {
            String sub = s.substring(i, i + 10);
            int hashValue = convertDNAStringToInt(sub);

            if (set.contains(hashValue) && !ans.contains(sub)) {
                ans.add(sub);
                set.remove(sub);
            } else {
                set.add(hashValue);
            }
        }

        return ans;
    }

    private static final int convertDNAStringToInt(String str) {
        int res = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char tmp = str.charAt(i);
            res |= (tmp & 0x07) << (i * 3);
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatDNASequences rds = new RepeatDNASequences();
        List<String> dnas = rds.findRepeatedDnaSequences("AAAAAAAAAA");
        for (String dna : dnas) {
            System.out.println(dna);
        }
    }
}
