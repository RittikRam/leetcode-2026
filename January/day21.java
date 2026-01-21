import java.util.List;
/*
3315. Construct the Minimum Bitwise Array II
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.

If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.


*/
public class day21 {
    
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int num = nums.get(i);
            if(num == 2){
                result[i]=-1;
                continue;
                }
            int ans = -1;
            for(int j=0; j<30; j++){
                if((num >>(j+1) & 1) == 0){
                    ans = num^(1<<j);
                    break;
                }
            }
            result[i]=ans;
        }
        return result;
    }
}
}
