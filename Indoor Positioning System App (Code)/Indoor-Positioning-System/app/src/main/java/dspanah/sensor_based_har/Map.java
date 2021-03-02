package dspanah.sensor_based_har;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Map {
    private Node[] nodes;
 //   private boolean[][] adj;
    private int n;

    public Map(Node []nodes,int n)
    {
        this.nodes = nodes;
       // this.adj = adj;
        this.n = n;
    }

    // a modified version of BFS that stores predecessor
// of each vertex in array p
// and its distance from source in array d
    public boolean BFS(int src, int dest,
             int pred[], int dist[])
    {

        Queue<Integer> queue = new LinkedList<>();
        int INT_MAX = 1000;

        boolean visited[] = new boolean[n];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            dist[i] = INT_MAX;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        int u;
        // standard BFS algorithm
        while (  queue.size() != 0) {

            u = queue.remove();

            for (int i = 0; i < nodes[u].neighbours.length; i++) {
                if (visited[nodes[u].neighbours[i]] == false) {
                    visited[nodes[u].neighbours[i]] = true;
                    dist[nodes[u].neighbours[i]] = dist[u] + 1;
                    pred[nodes[u].neighbours[i]] = u;
                    queue.add(nodes[u].neighbours[i]);

                    // We stop BFS when we find
                    // destination.
                    if (nodes[u].neighbours[i] == dest)
                        return true;
                }
            }
        }

        return false;
    }

    // utility function to print the shortest distance
// between source vertex and destination vertex
    public int[] getShortestPath(int s,int dest)
    {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int pred[] = new int[n];
        int dist[] = new int[n];

        if (BFS(s,dest,pred,dist) == false) {
            System.out.println("Given source and destination are not connected");
            return null;
        }

        // vector path stores the shortest path
        List<Integer> path = new ArrayList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // distance from source is in distance array
        System.out.println("Shortest path length is : "+dist[dest]);

        int[] path1 = new int[path.size()];
        // printing path from source to destination
        System.out.println("\nPath is: \n");
        for (int i = path.size() - 1,j=0; i >= 0; i--,j++)
        {
            path1[j] = path.get(j);
            System.out.println(path.get(i) + " ");
        }

        return path1;
    }

    public int numNodes()
    {
        return this.n;
    }

}
