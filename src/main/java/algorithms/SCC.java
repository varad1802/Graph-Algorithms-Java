package algorithms;

import entity.Vertex;
import utils.Utility;
import java.util.List;

public class SCC {

    public void stronglyConnected(List<Vertex> graph){
        DFS dfs = new DFS();
        /* Calculate DFS of the graph */
        dfs.dfs(graph);
        /* Calculate the transpose and order the vertices in decreasing order of finish time as of DFS */
        List<Vertex> transpose = Utility.getTranspose(graph);
        System.out.println("\n\nFollowing are the strongly connected components in the graph");
        /* Call DFS on the transpose graph */
        dfs.dfsTranspose(transpose);
    }
}
