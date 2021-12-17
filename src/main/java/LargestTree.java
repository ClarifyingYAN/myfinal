import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
        Stack<Integer> s = new Stack<>();
        s.push(u);
        visited.set(u, true);
        while (!s.isEmpty()) {
            int n = s.pop();
            for (int i = 0; i < adj[n].size(); i++) {
                if (!visited.get(adj[n].get(i))) {
                    size+=1;
                    visited.set(i, true);
                    for (int j = 0; j < adj[n].size(); j++) {
                        s.push(adj[n].get(j));
                    }
                }
            }
        }

        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        Vector<Boolean> marked = new Vector<>(V);
        for (int i = 0; i < V; i++) {
            marked.add(false);
        }
        int maxSize=0;
        for (int i = 0; i < V; i++) {
            if (!marked.get(i)) {
                int size = DFS(i, adj, marked);
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }
}