package contests;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class weekly_487 {
    /*q13827. Count Monobit Integers */
    class Solution {
    public int countMonobit(int n) {
        if(n == 0) return 1;
        int count = 1;
        int current = 1;
        while(current <= n){
            count++;
            current = (current<<1)|1;
        }
        return count;
    }
}
/*q2) 3829. Design Ride Sharing System */
class RideSharingSystem {
    Queue<Integer> riders;
    Queue<Integer> drivers;
    Set<Integer> riderSet;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        riderSet = new HashSet<>();
    }
    
    public void addRider(int riderId) {
        riders.offer(riderId);
        riderSet.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && !riderSet.contains(riders.peek())) {
        riders.poll(); 
    }
        if (riders.isEmpty() || drivers.isEmpty()) {
        return new int[]{-1, -1};
    }
        
        int rId = riders.poll();
        riderSet.remove(rId);
        int dId = drivers.poll();
        
        return new int[]{dId,rId};
    }
    
    public void cancelRider(int riderId) {
        riderSet.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
}
