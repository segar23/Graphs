import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public String getName (){
        return name;
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

    public void insertEdge (Edge edge){
        graph.add(edge);
    }

    public int findRoute(String src, String dst){
        for(int i = 0; i < graph.size(); i++){
            String source = graph.get(i).source.getName();
            String dest = graph.get(i).destination.getName();
            if(source.equals(src) && dest.equals(dst)){
                return graph.get(i).weight;
            }
        }

        return 0;
    }

    public void changeRoute(String src, String dst, int value){
        for(int i = 0; i < graph.size(); i++){
            String source = graph.get(i).source.getName();
            String dest = graph.get(i).destination.getName();
            if(source.equals(src) && dest.equals(dst)){
                graph.get(i).weight = value;
            }
        }
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

        graph.insertEdge(ws2in);
        graph.insertEdge(ws2cl);
        graph.insertEdge(in2ws);
        graph.insertEdge(in2ny);
        graph.insertEdge(in2fl);
        graph.insertEdge(ny2in);
        graph.insertEdge(ny2fl);
        graph.insertEdge(cl2ws);
        graph.insertEdge(cl2fl);
        graph.insertEdge(fl2cl);
        graph.insertEdge(fl2in);
        graph.insertEdge(fl2ny);

        List<Edge> edges = graph.getGraph();
        for (int i = 0; i < edges.size(); i++){
            System.out.println("Route " + (i+1) + ": " + edges.get(i).source.getName() + " to " +
            edges.get(i).destination.getName());
        }

        System.out.println("");
        System.out.println("<--------------------------->");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which route do you need to know?");
        System.out.println("Source: ");
        String source = scanner.nextLine();
        System.out.println("Destination: ");
        String destination = scanner.nextLine();
        System.out.println("<--------------------------->");

        int value = graph.findRoute(source, destination);
        System.out.println("Route cost: " + value);


        System.out.println("");
        System.out.println("<--------------------------->");
        System.out.println("");
        System.out.println("Which route do you need to change?");
        System.out.println("Source: ");
        source = scanner.nextLine();
        System.out.println("Destination: ");
        destination = scanner.nextLine();
        System.out.println("Which is the new value?");
        System.out.println("<--------------------------->");

        value = scanner.nextInt();
        graph.changeRoute(source, destination, value);
        System.out.println("Route changed!");
    }
}
