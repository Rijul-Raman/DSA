public class UndirectedGraphMatrix {
    int[][] adjMatrix;
    private int V, E;

    public UndirectedGraphMatrix(int nodes) {
        this.adjMatrix = new int[nodes][nodes];
        this.V = nodes;
        this.E = 0;
    }

    public void addEdge(int u, int v) {
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        this.E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges" + "\n");
        for(int v = 0;v<V;v++) {
            sb.append(v + ": ");
            for(int w : adjMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraphMatrix graph = new UndirectedGraphMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph);
    }
}
