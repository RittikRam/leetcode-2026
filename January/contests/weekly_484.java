import java.util.*;

class weekly_484 {

    // Question 1: Residue PrefixesGoal: Count prefixes where the number of unique characters equals the length of the prefix modulo some value (or a specific mathematical relationship between index and unique count).Your Solution:Javaclass Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
            if((i+1)%3 == set.size()){
                count++;
            }
        }
        return count;
    }

// Question 2: Number of Centered SubarraysGoal: Count subarrays where the total sum of the subarray is equal to at least one element within that same subarray.Your Solution:Javaclass Solution {
    public int centeredSubarrays(int[] nums) {
        if(nums.length == 1) return 1;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            long sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                set.add(nums[j]);
                // Safety check for long-to-int conversion
                if(sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
                    if(set.contains((int)sum)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

// Question 3: Count Caesar Cipher PairsGoal: Count pairs of strings that can be made identical by cyclically shifting all characters of one string by the same amount.Your Solution:Javaclass Solution {
    public long countPairs(String[] words) {
        HashMap<String, Long> map = new HashMap<>();
        long result = 0l;
        for(String s : words){
            int diff = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                int pos = s.charAt(i) - 'a';
                int newPos = (pos - diff + 26) % 26;
                sb.append((char)(newPos + 'a'));
            }
            String st = sb.toString();
            long occ = map.getOrDefault(st, 0l);
            result += occ;
            map.put(st, occ + 1);
        }
        return result;
    }
}
