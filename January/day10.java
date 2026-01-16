import java.util.Arrays;
/*
712. Minimum ASCII Delete Sum for Two Strings

Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
*/
public class day10 {
    int [][]t;
    public int minimumDeleteSum(String s1, String s2) {
        t=new int[s1.length()+1][s2.length()+1];
        for(int []rows: t){
            Arrays.fill(rows,-1);
        }
        return cost(s1,s2,s1.length(),s2.length());
    }
    public int cost(String s1,String s2, int l1,int l2){
        if(l1 == 0 && l2 == 0){
            return 0;
        }
        if(l1 == 0 || l2 ==0){
            int len = l1==0?l2:l1;
            String s = l1==0?s2:s1;
            int sum =0;
            for(int i=0; i<len; i++){
                sum += (int)s.charAt(i);
            }
            return sum;
        }
        if(t[l1][l2] != -1)return t[l1][l2];
        if(s1.charAt(l1-1) == s2.charAt(l2-1)){
            return t[l1][l2] = cost(s1,s2,l1-1,l2-1);
        }
        else{
            return t[l1][l2] =  (
                Math.min(
                    (int)s1.charAt(l1-1)+cost(s1,s2,l1-1,l2),
                    (int)s2.charAt(l2-1)+cost(s1,s2,l1,l2-1)
                )
            );
        }
        
    }
}




















