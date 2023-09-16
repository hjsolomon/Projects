import java.util.*;

public class Graph {

    ArrayList<LinkedList<Node>> aList;

    ArrayList<Node> nodes;
    int[][] matrix;

    Graph(int size) {
        matrix = new int[size][size];
        nodes = new ArrayList<>();
        aList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        aList.add(currentList);
        nodes.add(node);
    }

    public void addFlight(int src, int dst, double srcDepartureTime, double dstArrivalTime, double cost) {
        LinkedList<Node> currentList = aList.get(src);
        Node dstNode = aList.get(dst).get(0);
        currentList.add(dstNode);
        matrix[src][dst] = 1;
        (nodes.get(src)).setDepartureTime(srcDepartureTime);
        (nodes.get(dst)).setArrivalTime(dstArrivalTime);
        nodes.get(src).setCost(cost);
    }

    public boolean checkFlight(int src, int dst) {
        LinkedList<Node> currentList = aList.get(src);
        Node dstNode = aList.get(dst).get(0);

        for (Node node : currentList) {
            if (node == dstNode) {
                return true;
            }
            return false;
        }

        if (matrix[src][dst] == 1) {
            return true;
        }
        return false;
    }

    public void printAdjacencyList() {
        for (LinkedList<Node> currentList : aList) {
            for (Node node : currentList) {
                System.out.print(node.getData() + " -> ");
            }
            System.out.println();
        }

        }




    public void breadthFirstSearch(int src, int dst) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        int[] parent = new int[matrix.length];

        Arrays.fill(parent, -1);

        queue.offer(src);
        visited[src] = true;

        List<List<Integer>> allPaths = new ArrayList<>(); // Store all paths

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == dst) {
                // Found a destination, add the path to the list
                List<Integer> path = getPath(src, dst, parent);
                allPaths.add(path);
            }

            for (int i = 0; i < matrix[current].length; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    parent[i] = current;
                }
            }
        }

        rankAndPrintPaths(src, dst, allPaths);
    }

    private List<Integer> getPath(int src, int dst, int[] parent) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = dst;

        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);
        return path;
    }

    private void rankAndPrintPaths(int src, int dst, List<List<Integer>> allPaths) {
        // Sort paths by length (number of nodes)
        allPaths.sort(Comparator.comparingInt(List::size));

        System.out.println("Paths from " + nodes.get(src).getData() + " to " + nodes.get(dst).getData() + ":");
        for (int i = 0; i < allPaths.size(); i++) {
            List<Integer> path = allPaths.get(i);
            System.out.print("Path " + (i + 1) + ": ");
            for (int j = 0; j < path.size(); j++) {
                System.out.print(nodes.get(path.get(j)).getData());
                if (j < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" (Length: " + (path.size() - 1) + ")");
        }
    }

}