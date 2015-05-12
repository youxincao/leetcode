package com.leetcode;

import java.util.*;

/**
 * Created by weilun on 2015/5/12.
 */
public class RepeatDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s == null || s.length() < 10)
            return null;

        int count = s.length() - 10;
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                ans.add(sub);
                set.remove(sub);
            } else {
                if (!ans.contains(sub))
                    set.add(sub);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RepeatDNASequences rds = new RepeatDNASequences();
        List<String> dnas = rds.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String dna : dnas) {
            System.out.println(dna);
        }
    }
}
