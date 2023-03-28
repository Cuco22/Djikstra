import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    private int[] dist;                     // distanza minima dalla sorgente
    private boolean[] visited;              // indica se un nodo è stato visitato
    private PriorityQueue<Node> queue;      // coda di priorità per mantenere i nodi in ordine di distanza crescente
    private int[][] graph;                  // rappresentazione del grafo come matrice di adiacenza dei nodi

    private static final int INFINITY = Integer.MAX_VALUE;

    public void dijkstra(int[][] graph, int source) {
        this.graph = graph;
        int numNodes = graph.length;
        dist = new int[numNodes];
        visited = new boolean[numNodes];
        queue = new PriorityQueue<Node>(numNodes, new Node());

        // Inizializza la distanza di ogni nodo dalla sorgente come infinita
        Arrays.fill(dist, INFINITY);

        // Imposta la distanza della sorgente a zero e la aggiunge alla coda
        dist[source] = 0;
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {              //do' prorità ai nodi non visitati togliendo quelli già visitati dalla lista dei nodi con prorietà
            int u = queue.remove().node;           //nodo già visitato e quindi rimosso dalla lista

            // Se il nodo è già stato visitato, passa al prossimo
            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            // Cerca i nodi adiacenti a u e aggiorna la loro distanza se necessario
            for (int v = 0; v < numNodes; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int alt = dist[u] + graph[u][v];
                    if (alt < dist[v]) {
                        dist[v] = alt;
                        queue.add(new Node(v, dist[v]));
                        System.out.println(queue);
                    }
                }
            }
        }
    }

    // Classe interna per rappresentare un nodo con la sua distanza dalla sorgente
    private class Node implements Comparator<Node> {
        public int node;                    //nodo
        public int cost;                    //distanza

        public Node() {}

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compare(Node node1, Node node2) {                //confronto tra i nodi per distanza dalla sorgente
            if (node1.cost < node2.cost) {
                return -1;
            }
            if (node1.cost > node2.cost) {
                return 1;
            }
            return 0;
        }
    }
}
