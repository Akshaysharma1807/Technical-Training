package TechnicalTrain;
import java.util.*;

class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void unionSets(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class Exp_5 {
    public static int kruskals(int g_nodes, int[] g_from, int[] g_to, int[] g_weight) {
        int totalWeight = 0;
        int numEdges = g_from.length;
        Edge[] edges = new Edge[numEdges];
        for (int i = 0; i < numEdges; ++i) {
            edges[i] = new Edge(g_from[i], g_to[i], g_weight[i]);
        }
        Arrays.sort(edges);

        DisjointSet ds = new DisjointSet(g_nodes);
        for (Edge edge : edges) {
            int fromRoot = ds.find(edge.from - 1);
            int toRoot = ds.find(edge.to - 1);
            if (fromRoot != toRoot) {
                ds.unionSets(fromRoot, toRoot);
                totalWeight += edge.weight;
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int g_nodes = scanner.nextInt();
        int g_edges = scanner.nextInt();

        int[] g_from = new int[g_edges];
        int[] g_to = new int[g_edges];
        int[] g_weight = new int[g_edges];
        for (int i = 0; i < g_edges; ++i) {
            g_from[i] = scanner.nextInt();
            g_to[i] = scanner.nextInt();
            g_weight[i] = scanner.nextInt();
        }

        int result = kruskals(g_nodes, g_from, g_to, g_weight);
        System.out.println(result);

        scanner.close();
    }
}
