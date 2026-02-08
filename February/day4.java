import java.util.Arrays;

public class day4 {
    /*3640. Trionic Array II */
    class Solution {
    long t[][];
    public long maxSumTrionic(int[] nums) {
        t = new long[nums.length+1][4];
        for(long [] rows: t){
            Arrays.fill(rows, -1);
        }
        return solve(nums,0,0);
    }
    public long solve(int [] nums, int index, int trend){
        if(index == nums.length){
            if(trend == 3)return 0;
            else return Long.MIN_VALUE/2;
        }
        if(t[index][trend] != -1)return t[index][trend];
        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;
        
        if(trend == 0){
            skip = solve(nums,index+1, 0);
        }
        if(trend == 3){
            take = nums[index];
        }
        
        if(index+1 < nums.length){
            int curr = nums[index];
            int next = nums[index+1];
            if(trend == 0 && next>curr){
                take = Math.max(take,curr+solve(nums,index+1,1));
            }else if(trend == 1 ){
                if(next>curr){
                    take=Math.max(take, curr+solve(nums,index+1,1));
                }else if(next < curr){
                    take=Math.max(take,curr+solve(nums,index+1,2));
                }
            }else if(trend == 2){
                if(next<curr){
                    take=Math.max(take, curr+solve(nums,index+1,2));
                }else if(next > curr){
                    take=Math.max(take,curr+solve(nums,index+1,3));
                }
            }else if(trend == 3 && next>curr){
                take=Math.max(take,curr+solve(nums,index+1,3));
            }
        }
         return t[index][trend]= Math.max(take,skip);
    }
}
}
