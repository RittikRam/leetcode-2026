public class day3 {
     /*3637. Trionic Array I */
    class Solution {
    public boolean isTrionic(int[] nums) {
        int start=0,end=nums.length-1;
        while(start< nums.length-1 && nums[start+1] > nums[start]){
            start++;
        }
        if(start == 0 || start==nums.length)return false;
        
        while(end >0 && nums[end-1] < nums[end]){
            end--;
        }
        if(end== nums.length-1 || end == 0)return false;
        while(end >start && nums[end-1] > nums[end]){
            end--;
        }
        if(end == start)return true;
        return false;
    }
}
}
