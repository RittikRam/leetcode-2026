public class day18 {
    
/*
    1895. Largest Magic Square

Solved

Medium

TopicsCompanies



Hint

A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal. The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.

Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.



solution :*/

class Solution {

    int [][] rows, cols, dias, antis;



    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;

        int n = grid[0].length;

        rows = new int[m][n];

        cols = new int[m][n];

        dias = new int[m][n];

        antis = new int[m][n];

        

        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){

                rows[i][j] = grid[i][j]+(j>0?rows[i][j-1]:0);

                cols[i][j] = grid[i][j]+(i>0?cols[i-1][j]:0);



                dias[i][j] = grid[i][j]+(i>0&&j>0?dias[i-1][j-1]:0);

                antis[i][j] = grid[i][j]+(i>0&&j<n-1?antis[i-1][j+1]:0);

            }

        }



        for(int side = Math.min(m,n); side>1; side--){

            for(int i=0; i+side <= m; i++){

                for(int j=0; j+side <= n; j++){

                    if(check(grid,i,j,side))return side;

                }

            }

        }

        return 1;

    }

    public boolean check(int [][]grid, int r, int c, int k){

        int target = (rows[r][c+k-1])-((c>0)?rows[r][c-1]:0);



        for(int row=r+1; row<r+k; row++){

            int rSum = rows[row][c+k-1]-(c > 0 ? rows[row][c - 1] : 0);

            if(rSum!= target)return false;

        }



        for(int col=c+1; col<c+k; col++){

            int cSum = cols[r+k-1][col]-(r > 0 ? cols[r - 1][col] : 0);

            if(cSum != target)return false;

        }





        int mainDiag = dias[r+k-1][c+k-1]-(r > 0 && c > 0 ? dias[r - 1][c - 1] : 0);

        if (mainDiag != target) return false;



        int antiDiag = antis[r+k-1][c]-(r>0&&(c+k)<grid[0].length?antis[r-1][c+k]:0);

        if (antiDiag != target) return false;

        return true;

    }

}
}
