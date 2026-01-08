/*
1458. Max Dot Product of Two Subsequences
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

*/

import java.util.*;

public class day08 {
    int t[][];
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        t = new int[l1+1][l2+1];
        for(int [] rows : t){
            Arrays.fill(rows,-1);
        }
        return solve(nums1,nums2,l1,l2);
    }
    public int solve(int [] n1, int [] n2, int l1, int l2){
        if(l1 == 0 || l2 == 0){
            return -10_000_000;
        }
        if(t[l1][l2] != -1){
            return t[l1][l2];
        }
        int prod = n1[l1-1]*n2[l2-1]+Math.max(0,solve(n1,n2,l1-1,l2-1));
        int left = solve(n1,n2,l1-1,l2);
        int right = solve(n1,n2,l1,l2-1);
        return t[l1][l2] = Math.max(prod,Math.max(left,right));
    }
}