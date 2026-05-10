public class Experiment {
    public void runMultipleTests() {
        System.out.println("===== SMALL GRAPH (10 vertices) =====");
        Graph small = createGraph(10);
        runTest(small);
        System.out.println("\n===== MEDIUM GRAPH (30 vertices) =====");
        Graph medium = createGraph(30);
        runTest(medium);
        System.out.println("\n===== LARGE GRAPH (100 vertices) =====");
        Graph large = createGraph(100);
        runTest(large);
    }
    private Graph createGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }
        return g;
    }
    private void runTest(Graph g) {
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        System.out.println("BFS Time: " + (endBfs - startBfs) + " ns");
        System.out.println("DFS Time: " + (endDfs - startDfs) + " ns");
    }
}