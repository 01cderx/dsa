package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge{
        int src;
        int dest;
        // int wt;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }
    // For UnWeighted Graph
    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<Edge>();

    //     }
    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1, 2));
    //     graph[1].add(new Edge(1, 3));

    //     graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 1));
    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 1));
    //     graph[3].add(new Edge(3, 2));
    // }

      

    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<Edge>();

    //     }
    //     graph[0].add(new Edge(0, 2, 2));

    //     graph[1].add(new Edge(1, 2, 10));
    //     graph[1].add(new Edge(1, 3, 0));

    //     graph[2].add(new Edge(2, 0, 2));
    //     graph[2].add(new Edge(2, 1, 10));
    //     graph[2].add(new Edge(2, 3, -1));

    //     graph[3].add(new Edge(3, 1, -1));
    //     graph[3].add(new Edge(3, 2, 0));

    // }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start) {
        Queue<Integer> q = new LinkedList<>();
        // boolean visited[] = new boolean[V];
        // q.add(0);
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (!visited[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr+" ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    // All paths from source to destination

    public static void printAllPath(ArrayList<Edge> graph[], boolean visited[] , int curr, String path, int tar) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                visited[curr] = true;
                printAllPath(graph, visited, e.dest, path+e.dest, tar);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        // int V = 4;
        int V = 7;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        
        // for (int i = 0; i < graph[1].size(); i++) {
            //     Edge e = graph[1].get(i);
            //     System.out.print(e.dest+" ");
            // }
            
            // for (int i = 0; i < graph[2].size(); i++) {
                //     Edge e = graph[2].get(i);
                //     System.out.println(e.dest+" , "+e.wt);
                // }
                
                @SuppressWarnings("unchecked")
                ArrayList<Edge> graph[] = new ArrayList[V];
                createGraph(graph);

        // boolean visited[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if (visited[i] == false) {
        //         bfs(graph, V, visited, i);
        //     }
        // }
        // System.out.println();

        // boolean visited[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if (visited[i] == false) {
        //         dfs(graph, 0, visited);
        //     }
        // }
        // System.out.println();

        // int src = 0, tar = 5;
        // boolean visited[] = new boolean[V];
        // printAllPath(graph, visited, src, src+"", tar);
    }
}