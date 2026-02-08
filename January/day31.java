public class day31 {
    /*744. Find Smallest Letter Greater Than Target */
    class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length;
        char result=letters[0];
        while(start < end){
            int mid = start+(end-start)/2;
            if(target < letters[mid]){
                result=letters[mid];
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return result;
    }
}
}
