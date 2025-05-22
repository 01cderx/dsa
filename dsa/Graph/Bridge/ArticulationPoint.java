package Graph.Bridge;

import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static int time = 0;

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        
        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[], int dt[], int low[], int par, boolean ap[]) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            }

            if (!visited[neigh]) {
                dfs(graph, neigh, visited, dt, low, curr, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true;
                }

                child++;
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if (par == -1 && child > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, dt, low, -1, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("Articulation Point: " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}
