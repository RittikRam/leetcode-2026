/*1975. Maximum Matrix Sum
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
*/
public class day05 {
     public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        long totalSum = 0;
        int negCount=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                totalSum = totalSum+ (Math.abs(matrix[i][j]));
                if(Math.abs(matrix[i][j]) < min){
                    min = Math.abs(matrix[i][j]);
                }
                if(matrix[i][j] < 0){
                    negCount++;
                }
            }
        }
        if((negCount & 1) == 0)return totalSum;
        return totalSum-(2*(min));
    }
}
