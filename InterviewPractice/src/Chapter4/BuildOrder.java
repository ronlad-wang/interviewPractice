package Chapter4;

public class BuildOrder {

    /*
    You are given a list of projects and a list of dependencies (which is a list of pairs of
    projects, where the second project is dependent on the first project). All of a project's
    dependencies must be built before the project is. Find a build order that will allow the
    projects to be built. If there is no valid build order, return an error.

    EXAMPLE:
    Input:
        projects: a, b, c, d, e, f
        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    Output: f, e, a, b, d, c
     */

    public static int[] buildOrder(int[] projects, int[][] dependencies) {
        /*
        holy crap guys I'm a genius for solving this question I think
        quick note, the version of graphNode I implemented only takes ints so we'll assume that we get
        int[]
        Also we'll say dependencies is an array of int[]s with length 2, index 0 will be the thing we
        need to build first, the second is the thing we build next

        The way we solve this is using a directed graph. We iterate through the dependencies list
        and look at every dependency, and draw edges between the corresponding nodes on the graph,
        where the start of the edge is the needed item and the end of the edge is the needing item.

        While doing this we also keep track of which nodes have no edges directed to them. We'll need
        this for later.

        Once we finish creating the graph, we perform a BFS search on each of the nodes. But, we need
        to maintain a list of visited nodes throughout the BFS searches. Our multiple BFS searches
        combined should not visit the same node twice.
        Finally, our solution will be the output from those BFS searches ARRANGED IN REVERSE ORDER
        OF THE ORDER IN WHICH THEIR CORRESPONDING BFS SEARCHES TOOK PLACE
        this important order reversal solves a problem with double dependencies. To see this problem
        try doing the example with dependency (e, a) instead of (f, a), it comes up when you have
        multiple top nodes that are required for a particular node inside the graph with multiple
        dependencies
        */
    }
}
