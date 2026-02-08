import java.util.Arrays;

public class day6 {
    /*3634. Minimum Removals to Balance Array */
    class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n == 1)return 0;
        Arrays.sort(nums);
        int start=0,end=1;
        int maxLen=-1;
        while(start<n && end < n){
            while(end < n && nums[start]>=Math.ceil((double)nums[end]/k)){
                end++;
            }
            maxLen=Math.max(maxLen,end-start);
            start++;
        }
        return n-maxLen;
    }
}
}
