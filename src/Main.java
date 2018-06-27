import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    List<Edge> edges;

    public Node (String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge (Edge edge) {
        edges.add(edge);
    }
}

class Edge {
    Node source;
    Node destination;
    int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    List<Edge> graph;

    public Graph () {
        graph = new ArrayList<>();
    }

    public List<Edge> getGraph(){
        return graph;
    }
}





public class Main {
    public static void main (String [] args) {
        Graph graph = new Graph();

        Node washington = new Node("Washington");
        Node indiana = new Node("Indiana");
        Node newyork = new Node("New York");
        Node california = new Node("California");
        Node florida = new Node("Florida");

        Edge ws2in = new Edge(washington, indiana, 5);
        Edge ws2cl = new Edge(washington, california, 3);
        washington.addEdge(ws2cl);
        washington.addEdge(ws2in);

        Edge in2ws = new Edge(indiana, washington, 5);
        Edge in2ny = new Edge(indiana, newyork, 4);
        Edge in2fl = new Edge(indiana, florida, 6);
        indiana.addEdge(in2fl);
        indiana.addEdge(in2ny);
        indiana.addEdge(in2ws);

        Edge ny2in = new Edge(newyork, indiana, 4);
        Edge ny2fl = new Edge(newyork, florida, 7);
        newyork.addEdge(ny2fl);
        newyork.addEdge(ny2in);

        Edge cl2ws = new Edge(california, washington, 3);
        Edge cl2fl = new Edge(california, florida, 8);
        california.addEdge(cl2ws);
        california.addEdge(cl2fl);

        Edge fl2cl = new Edge(florida, california, 8);
        Edge fl2in = new Edge(florida, indiana, 6);
        Edge fl2ny = new Edge(florida, newyork, 7);
        florida.addEdge(fl2cl);
        florida.addEdge(fl2in);
        florida.addEdge(fl2ny);

        System.out.print("Edge : " + graph.getGraph().get(0));
    }
}
