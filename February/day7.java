public class day7 {
   /*1653. Minimum Deletions to Make String Balanced */
   class Solution {
    private class count{
        public int bcount;
        public int acount;
    }
    public int minimumDeletions(String s) {
        int n = s.length();
        count[] counts = new count[n];
        for(int k=0; k<n; k++) {
        counts[k] = new count();
    }
        int b1=0,a1=0;
        for(int i=0,j=n-1; i<n; i++,j--){
            counts[i].bcount=b1;
            counts[j].acount=a1;
            if(s.charAt(i)=='b')b1++;
            if(s.charAt(j)=='a')a1++;
        }
        int minval = n;
        for(int i=0; i<n; i++){
                minval = Math.min(minval,counts[i].bcount+counts[i].acount);
        }
        return minval;
    }
}
}
