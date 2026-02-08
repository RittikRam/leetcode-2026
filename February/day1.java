public class day1 {
    /*3010. Divide an Array Into Subarrays With Minimum Cost I */
    class Solution {
    public int minimumCost(int[] nums) {
        if(nums.length == 3)return nums[0]+nums[1]+nums[2];
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < second){
                third=second;
                second=nums[i];
            }else if(nums[i] < third){
                third=nums[i];
            }
        }
        return first+second+third;
    }
}
}
