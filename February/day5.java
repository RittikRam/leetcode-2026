public class day5 {
    /*3379. Transformed Array */
    class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] == 0)result[i]=nums[i];
            else{
                int index = (i+nums[i])%n;
                if(index >= 0){
                    result[i]=nums[index];
                }else{
                    result[i]=nums[n+index];
                }
            }
        }
        return result;
    }
}
}
