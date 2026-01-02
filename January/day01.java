//PROBLEM - 66- PLUS ONE
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/
class day01 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        int carry = 1;
        while(i>=0){
            int digit = digits[i]+carry;
            digits[i]= digit%10;
            carry = digit/10;
            if(carry == 0)break;
            i--;
        }
        if(carry !=0){
            int [] result = new int[n+1];
            result [0] = 1;
            int j =1;
            for(int val: digits){
                result[j++]=val;
            }
            return result;
        }
       return digits;
    }
}