/*
1411. Number of Ways to Paint N × 3 Grid
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the
 three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color 
 (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. 
As the answer may grow large, the answer must be computed modulo 109 + 7. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day03 {
    long MOD = 1000000007; 
     int memo[][];
     List<Integer> [] neighbours;  
     int N;
    public int numOfWays(int n) {
        this.N = n;
     List<int[]> states = new ArrayList<>();
     for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                if(i != j && j!= k){
                    states.add(new int[]{i,j,k});
                }
            }
        }
     }
     neighbours = new ArrayList[12];
     for(int i=0; i<12; i++){
        neighbours[i] = new ArrayList<>();
        for(int j=0; j<12; j++){
            int [] p1 = states.get(i);
            int [] p2 = states.get(j);
            if (p1[0] != p2[0] && p1[1] != p2[1] && p1[2] != p2[2]) {
                    neighbours[i].add(j);
                }
        }
     }
     
     memo = new int[n][12];
     for(int [] m : memo){
        Arrays.fill(m,-1);
     }
     long result = 0;
     for(int i=0; i<12; i++){
        result += solve(1,i)%MOD;
     }
    

     return (int)(result%MOD);
    }
    private int solve(int curr, int prev){
        if(curr == N){
            return 1;
        }
        if (memo[curr][prev] != -1) {
            return memo[curr][prev];
        }
        long count=0;
        for(int next : neighbours[prev]){
            count += solve(curr+1,next)%MOD;
        }
        return memo[curr][prev] = (int)(count%MOD);
    }
}
