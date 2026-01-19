public class day19 {
    /*
    1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

G   iven a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
    */

class Solution {
    int [][]rows;
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        rows = new int[m][n+1];
       
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i][j+1] = mat[i][j] + rows[i][j];
            }
        }
        int ans=0;
        int start = 1;
        int end = Math.min(m,n);
        while(start <= end){
            int side = start+(end-start)/2;
            boolean found = false;
            for(int i=0; i<= m-side; i++){
                for(int j=0; j<= n-side; j++){
                    if(check(mat,i,j,side,threshold)){
                        found=true;
                        break;
                    }
                }if(found)break;
            }
            if(found){
                ans=side;
                start=side+1;
            }else{
                end = side-1;
            }
        }
        return ans;
    }
    public boolean check(int [][] mat, int r, int c, int side,int target){
        int sqSum = 0;
        for(int i=r; i<r+side; i++){
            int levelSum = rows[i][c+side]-rows[i][c];
            sqSum += levelSum;
        }
        return target >= sqSum;
    }
}
}
