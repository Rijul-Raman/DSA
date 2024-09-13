import java.util.LinkedList;

public class UndirectedGrapList {
    LinkedList<Integer>[] adj;
    private int V, E;

    @SuppressWarnings("unchecked")
    public UndirectedGrapList(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int i = 0;i<nodes;i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        this.E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges" + "\n");
        for(int v = 0;v<V;v++) {
            sb.append(v + ": ");
            for(int w = 0;w<this.adj[v].size();w++) {
                sb.append(this.adj[v].get(w) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGrapList graph = new UndirectedGrapList(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph);
    }

    //1:08:21:25
}
