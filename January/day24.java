import java.util.Arrays;

public class day24 {
    /*1877. Minimize Maximum Pair Sum in Array */
    class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i=0,j=nums.length-1; i<nums.length/2; i++,j--){
            int sum = nums[i]+nums[j];
            if(sum > ans)ans=sum;
        }
        return ans;
    }
}
}
