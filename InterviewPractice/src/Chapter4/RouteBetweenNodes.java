package Chapter4;

import DataStructures.GraphNode;

import java.util.HashSet;

public class RouteBetweenNodes {
    /*
    Given a directed graph, design an algorithm to find out whether there is a
    route between two nodes.
     */

    public static class ResultWrapper {
        public HashSet<GraphNode> visited;
        public boolean foundRoute;

        public ResultWrapper(HashSet<GraphNode> v, boolean f) {
            visited = v;
            foundRoute = f;
        }
    }

    public static boolean routeExists(GraphNode from, GraphNode to) {
        //this is a recursive DFS search that is implemented using a HashSet
        //we use a hashSet since hashSets can perform contains in O(1) time, and we only care
        //about whether or not we have visited a node, not what index it is at
        HashSet<GraphNode> visited = new HashSet<>();
        if(from == to) {
            return true;
        }
        //we need this helper method because we need to actively change the visited list
        //we could also do this with an instance variable
        return routeExistsHelper(from, to, visited).foundRoute;
    }

    public static ResultWrapper routeExistsHelper(GraphNode from, GraphNode to, HashSet<GraphNode> visited) {
        for(int i = 0; i < from.getConnections().size(); i++) {
            //iterate through every node that is connected to the from node

            if(!visited.contains(from.getConnections().get(i))) {
                //if we haven't visited this node we need to check it

                if(from.getConnections().get(i) == to) {
                    //if this is the node we're looking for we've found a route. ez
                    return new ResultWrapper(visited, true);
                }

                //otherwise, we need to go into that node and see if that gives us a route
                visited.add(from.getConnections().get(i));
                ResultWrapper depthCheck = routeExistsHelper(from.getConnections().get(i), to, visited);
                if(depthCheck.foundRoute) {
                    return new ResultWrapper(visited, true);
                }

                //if that node doesn't give it a route, we mark it down to skip later and
                //keep iterating
                visited = depthCheck.visited;
            }
        }

        //if we get through the whole loop without finding a route, then this node is a dead end
        return new ResultWrapper(visited, false);
    }

    public static void main(String[] args) {
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(1);
        GraphNode g3 = new GraphNode(1);
        GraphNode g4 = new GraphNode(1);
        GraphNode g5 = new GraphNode(1);
        GraphNode g6 = new GraphNode(1);

        g1.connect(g5);
        g1.connect(g2);
        g2.connect(g4);
        g3.connect(g4);
        g4.connect(g1);
        g5.connect(g4);
        g5.connect(g1);

        System.out.println(routeExists(g1, g5));
        System.out.println(routeExists(g1, g4));
        System.out.println(routeExists(g1, g3));
    }
}
