import java.util.Arrays;

public class day25 {
    /*1984. Minimum Difference Between Highest and Lowest of K Scores */
    class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1)return 0;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int ans = Integer.MAX_VALUE;
        while(j < n){
            if(j-i+1 == k){
                ans = Math.min(ans,(nums[j]-nums[i]));                
                i++;
            }
            j++;
        }
        return ans;
    }
}
}
