import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/* leetcode problem number 3650 */
public class day27 {
    class Solution {
    private class Edge{
    int dest;
    int weight;
    public Edge(int dest, int weight){
        this.dest=dest;
        this.weight=weight;
    }
    }
    private ArrayList<ArrayList<Edge>> list;

    public int minCost(int n, int[][] edges) {
        list = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int []  arr: edges){
            list.get(arr[0]).add(new Edge(arr[1],arr[2]));
            list.get(arr[1]).add(new Edge(arr[0],2*arr[2]));
            }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int u = current.dest;
            int cost = current.weight;

            if(cost > dist[u])continue;

            if(u == n-1)return cost;

            for(Edge e : list.get(u)){
                int next = e.dest;
                int w = e.weight;

                if(dist[u] + w < dist[next]){
                    dist[next] = dist[u]+w;
                    pq.offer(new Edge(next, dist[next]));
                }
            }
        }
        return -1;
    }
}
}
