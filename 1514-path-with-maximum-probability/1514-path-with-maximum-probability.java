import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int node;
    double prob;

    public Edge(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}

class Pair {
    int node;
    double distance;

    public Pair(int node, double distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Creating a graph for adjacency list
        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }

        //Printing the list
        //for (int i = 0; i < n; i++) {
          //  System.out.print("Adjacency list for node " + i + ": ");
            //for (Edge edge : adj.get(i)) {
              //  System.out.print("(" + edge.node + ", " + edge.prob + ") ");
            //}
            //System.out.println();
        //}
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Double.compare(y.distance, x.distance));

        double[] dist = new double[n];
        //No need to initialize with min since arrays are always are initialized with zero unless mentioned we anyway have min
        
        dist[start_node] = 1.0; // Initialize with 1.0 for probability
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            double prob = pq.peek().distance;
            pq.remove();

            if (node == end_node)
                return prob;

            for (int i = 0; i < adj.get(node).size(); i++) {
                double edgeProb = adj.get(node).get(i).prob;
                int neighbour = adj.get(node).get(i).node;
                double temp = edgeProb * prob;

                if (temp > dist[neighbour]) {
                    dist[neighbour] = temp;
                    pq.add(new Pair(neighbour, dist[neighbour]));
                }
            }
        }

        return 0.0;
    }
}

