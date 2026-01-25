import java.util.ArrayList;
import java.util.List;

public class day22 {
    /*3507. Minimum Pair Removal to Sort Array I */
    class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
            for (int i : nums) {
                list.add(i);
                }
        int count = 0;
        while(!isSorted(list)){
                int index = findMin(list);
                int sum = list.get(index)+list.get(index+1);
                list.remove(index);
                list.remove(index);
                list.add(index,sum);                
                count++;
            
        }
        return count;
    }
    public int findMin(List<Integer> nums){
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=0; i<nums.size()-1; i++){
            int sum = nums.get(i)+nums.get(i+1);
            if(sum < min){
                min = sum;
                index =i;
            }
        }
        return index;
    }

    public boolean isSorted(List<Integer> nums){
        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i+1) < nums.get(i)){
                return false;
            }
        }
        return true;
    }
}
    
}
