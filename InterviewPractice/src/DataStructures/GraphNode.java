package DataStructures;

import java.util.ArrayList;

public class GraphNode {
    private int item;
    private ArrayList<GraphNode> connections;

    public GraphNode(int i) {
        item = i;
        connections = new ArrayList<GraphNode>();
    }
    public void connect(GraphNode to) {
        connections.add(to);
    }
    public int getItem() {
        return item;
    }
    public ArrayList<GraphNode> getConnections() {
        return connections;
    }
}
