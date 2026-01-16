import java.util.Arrays;

public class day15 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int height = 1;
        int maxHeight = 1;
        int width = 1;
         int maxWidth = 1;

        for(int i=1; i< hBars.length; i++){
            if(hBars[i] == hBars[i-1]+1){
                height +=1;
            }else{
                height=1;
            }
            maxHeight = Math.max(maxHeight,height);
        }

        for(int i=1; i< vBars.length; i++){
            if(vBars[i] == vBars[i-1]+1){
                width +=1;
            }else{
                width=1;
            }
            maxWidth = Math.max(maxWidth,width);
        }

        int longestSquareGap = Math.min(maxHeight+1,maxWidth+1);
        return longestSquareGap*longestSquareGap;
    }
}