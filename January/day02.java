/*961. N-Repeated Element in Size 2N Array
Solved
Easy
Topics
premium lock icon
Companies
You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.

 */
import java.util.*;

public class day02 {  
    public int repeatedNTimes(int[] nums) {
          Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                return n;
            }
            map.put(n,1);
        }
       
        return 0;
    }  
}
