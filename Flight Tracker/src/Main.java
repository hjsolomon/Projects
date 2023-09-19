import java.util.List;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(10);


        graph.addNode(new Node(0, "JFK"));
        graph.addNode(new Node(1, "LAX"));
        graph.addNode(new Node(2, "ATL"));
        graph.addNode(new Node(3, "DEN"));


        graph.addFlight(0, 1);
        graph.addFlight(0, 2);
       graph.addFlight(2, 3);
       graph.addFlight(1, 2);


       graph.printAdjacencyList();

       graph.breadthFirstSearch(0, 3);




    }
}
