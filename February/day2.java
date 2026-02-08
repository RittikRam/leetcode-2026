import java.util.TreeMap;

public class day2 {
    /*3013. Divide an Array Into Subarrays With Minimum Cost II */
    class Solution {
    private long currSum = 0;
    private int leftCount = 0;
    private int rightCount = 0;
    private TreeMap<Integer, Integer> left = new TreeMap<>();
    private TreeMap<Integer, Integer> right = new TreeMap<>();
    
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        if(n == 3)return nums[0]+nums[1]+nums[2];
        int maxElements = k-1;
        for(int i=1; i<dist+2; i++){
            add(nums[i],maxElements);
        }
        long minSum = currSum;
        for(int i= dist+2; i<n; i++){
            remove(nums[i-(dist+1)],maxElements);
            add(nums[i],maxElements);
            minSum=Math.min(minSum,currSum);
        }
        return nums[0]+minSum;
    }

    private void add(int num, int maxElements) {
        left.put(num,left.getOrDefault(num,0)+1);
        currSum+=num;
        leftCount++;
        if(leftCount>maxElements){
            int largest = left.lastKey();
            removeKey(left,largest);
            currSum -= largest;
            leftCount--;
            right.put(largest,right.getOrDefault(largest,0)+1);
            rightCount++;
        }
    }
    public void remove(int val, int count){
        if(left.containsKey(val)){
            removeKey(left,val);
            currSum-=val;
            leftCount--;
        }else{
            removeKey(right,val);
            rightCount--;
        }
        if(leftCount < count && rightCount >0){
            int smallest = right.firstKey();
            removeKey(right,smallest);
            rightCount--;

            left.put(smallest,left.getOrDefault(smallest,0)+1);
            leftCount++;
            currSum+=smallest;
        }
    }

    private void removeKey(TreeMap<Integer, Integer> map, int largest) {
        int count = map.get(largest);
        if(count == 1)
        map.remove(largest);
        else
        map.put(largest,count-1);
    }
}
}
