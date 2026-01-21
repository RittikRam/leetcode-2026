import java.util.List;
/*
3314. Construct the Minimum Bitwise Array I
You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.

If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.

*/
public class day20 {
    class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int num = nums.get(i);
            int low = 1;
            int high = num-1;
            int ans=-1;
            while(low <= high){                
                if((high|(high+1)) == num){
                    ans=high;
                }high--;
            }
            result[i]=ans;
        }
        return result;
    }
}
}
