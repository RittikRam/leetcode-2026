public class biweekly_175 {
    /*q1)3823. Reverse Letters Then Special Characters in a String */
    class Solution {
    public String reverseByType(String s) {
        int ll=0,ls=0;
        int rl=s.length()-1;
        int rs=rl;
        char [] arr = s.toCharArray();
        while(ll < rl){
            while(ll < rl && !Character.isLetter(arr[ll]))ll++;
           
            while(ll < rl && !Character.isLetter(arr[rl]))rl--;
            swap(arr,ll,rl);
            ll++;rl--;
        }
        while(ls < rs){
            while(ls < rs &&Character.isLetter(arr[ls]))ls++;
            while(ls < rs && Character.isLetter(arr[rs]))rs--;
            swap(arr,ls,rs);ls++;rs--;
        }
        return String.valueOf(arr);
    }
    public void swap(char [] arr, int i, int j){
        char temp1 = arr[i];
        arr[i]=arr[j];
        arr[j]=temp1;
    }
}
/*3824. Minimum K to Reduce Array Within Limit */
class Solution2 {
    public int minimumK(int[] nums) {
        int max = nums[0];
        for(int num: nums){
            max=Math.max(num,max);
        }
        int start = 1;
        int end = Math.max(max, 100000);
        int ans = max;
        while(start <= end){
            long numOfOp=0;
            int mid = start+(end-start)/2;
            for(int num:nums){
                int op = (num+mid-1)/mid;
                numOfOp += op;
            }
            if(numOfOp <= mid*(long)mid){
                ans=mid;
                end=mid-1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }
}
}
