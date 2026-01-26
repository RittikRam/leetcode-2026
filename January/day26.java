import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day26 {
    /*leetcode 1200: Minimum Absolute Difference */
    class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int minAbsDiff = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            int diff =  Math.abs(arr[i]-arr[i+1]);
            if(diff < minAbsDiff){
                minAbsDiff=diff;
            }
        }

        int i=0,j=1; 
        List<List<Integer>> list = new ArrayList<>();
        while(j<n){
            int diff = arr[j]-arr[i];
            if(diff == minAbsDiff)
                list.add(new ArrayList<>(List.of(arr[i],arr[j])));
                i++;
                j++;
        }
        return list;
    }
}
}