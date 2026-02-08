package contests;
import java.util.*;

public class weekly_488 {
    
    
        // q1)
        class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        int total = prefix[n-1];
        int i=0;
        int count = 0;
        while(i<n-1){
            int sum = total-prefix[i];
            if(nums[i]>sum/(n-i-1)){
                count++;
            }
            i++;
        }
        return count;
    }
}

        // q2)
        class Solution2 {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> list = new ArrayList<>();
        Deque<Long> stack = new ArrayDeque<>();
        int n = nums.length;
        int i=0;
        while(i < n){
            long currVal = nums[i];
            while(!stack.isEmpty() && stack.peek() == currVal){
                long left = stack.pop();
                currVal=left+currVal;
            }
                stack.push(currVal);
            
        
            i++;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;
    }
}

        // q3)
        class Solution3 {
    int k;
    Long t[][][];
    public long maxScore(int[] nums1, int[] nums2, int K) {
        k=K;
        int n1=nums1.length;
        int n2 = nums2.length;
        t=new Long[n1+1][n2+1][k+1];
       
        return solve(nums1,nums2,0,0,0);
    }
    public long solve(int[] n1, int[] n2, int i, int j, int it){
        if(it==k)return 0L;
        if (i >= n1.length || j >= n2.length) {
            return -(long) -1e15; 
        }
        if(t[i][j][it] != null)return t[i][j][it];
        long skip1 = solve(n1,n2,i+1,j,it);
        long skip2 = solve(n1,n2,i,j+1,it);
        long take = -(long) -1e15;
        long remaining = solve(n1,n2,i+1,j+1,it+1);
        if(remaining != -(long) -1e15){
            take = (long)n1[i]*n2[j] + remaining;
        }
        return t[i][j][it] = Math.max(Math.max(skip1,skip2),take);
    }
}
    
}
