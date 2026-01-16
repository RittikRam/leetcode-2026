/*
leetcode 2975
*/

import java.util.HashSet;

public class day16 {
    Solution sol = new Solution();
}

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> set = new HashSet<>();

        int [] h = new int[hFences.length+2];
        newDist(h,hFences,m);
        int [] v = new int[vFences.length+2];
        newDist(v,vFences,n);
       

        findDistance(m,set,h);
           
       
        int maxSide = -1;
        
        for(int i=v.length-1; i>0; i--){
            for(int j=i-1; j>=0; j--){
                int diff = Math.abs(v[i]-v[j]);
                if(set.contains(diff)){
                    maxSide = Math.max(maxSide,diff);
                }
            }
        }
        if(maxSide == -1)return -1;
        long MOD  = 1_000_000_007L;
        long area = (long) maxSide*maxSide;
        return (int)(area%MOD);
    }
    public void findDistance(int m,HashSet<Integer> set, int []h){
        for(int i=h.length-1; i>0; i--){
            for(int j=i-1; j>=0; j--){
                set.add(Math.abs(h[i]-h[j]));
            }
        }
    }
    public void newDist(int []v, int []vFences,int n){
         for(int i=0; i<vFences.length; i++){
            v[i]=vFences[i];
        }

        v[v.length-2]=1;
        v[v.length-1]=n;
    }
}