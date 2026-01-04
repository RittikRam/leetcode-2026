/*problem :

 1390. Four Divisors
 Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. 
 If there is no such integer in the array, return 0.

*/

class day04 {

    public int sumFourDivisors(int[] nums) {

        int total = 0;

        for (int num : nums) {

            int i = 2;
            int divisor = 0;
            int sum = 0;

            while (i * i <= num) {
                if (num % i == 0) {
                    if (i != (num / i))
                        divisor += 2;
                    else
                        divisor += 1;
                    sum += i;
                    sum = sum + (num / i);

                }
                if (divisor > 2)
                    break;
                i++;

            }
            if (divisor == 2) {
                total += sum;
                total += num;
                total += 1;
            }
        }
        return total;

    }

}