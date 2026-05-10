import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Graph {
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;
    public Graph() {
        adjacencyList = new HashMap<>();
    }
    public void addVertex(Vertex v) {
        adjacencyList.put(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
    }
    public void printGraph() {
        for (Integer vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjacencyList.get(vertex));
        }
    }
    public void bfs(int start) {
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start) {
        boolean[] visited = new boolean[adjacencyList.size()];
        System.out.print("DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }
    private void dfsHelper(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}