import java.util.PriorityQueue;

public class day23 {
    /*3510. Minimum Pair Removal to Sort Array II */
    class Solution {
    class Pair implements Comparable<Pair> {
        int index;
        long sum;
        Pair(int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.sum != o.sum) {
                return Long.compare(this.sum, o.sum);
            }
            return Integer.compare(this.index, o.index);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        long[] val = new long[n];
        int[] L = new int[n];
        int[] R = new int[n];
        boolean[] alive = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            val[i] = nums[i];
            L[i] = i - 1;
            R[i] = i + 1;
            alive[i] = true;
        }
        R[n - 1] = -1;

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(i, val[i] + val[i + 1]));
            if (val[i] > val[i + 1]) count++;
        }

        int ans = 0;

        while (count > 0) {
            Pair top = pq.poll();
            int left = top.index;

            if (!alive[left]) continue;

            int right = R[left];
            if (right == -1 || !alive[right]) continue;

            if (val[left] + val[right] != top.sum) continue;

            // Remove old inversion relations
            if (val[left] > val[right]) count--;

            int prev = L[left];
            int next = R[right];

            if (prev != -1 && alive[prev] && val[prev] > val[left]) count--;
            if (next != -1 && alive[next] && val[right] > val[next]) count--;

            // Merge
            ans++;
            val[left] += val[right];
            alive[right] = false;

            R[left] = next;
            if (next != -1) L[next] = left;

            // Add new inversion relations
            if (prev != -1 && alive[prev]) {
                if (val[prev] > val[left]) count++;
                pq.offer(new Pair(prev, val[prev] + val[left]));
            }

            if (next != -1 && alive[next]) {
                if (val[left] > val[next]) count++;
                pq.offer(new Pair(left, val[left] + val[next]));
            }
        }

        return ans;
    }
}

}
