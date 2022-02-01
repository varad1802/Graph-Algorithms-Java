package algorithms;

import entity.Edge;
import entity.Vertex;

import java.util.List;

public class DFS {

    Integer time;

    public void dfs(List<Vertex> graph){
        time = 0;
        System.out.println("DFS: ");
        for (Vertex u: graph) {
            /* Call DFS-VISIT for each node that has not been visited */
            if(u.getColor().equals("WHITE")){
                dfsVisit(graph, u);
            }
        }
    }

    /* Function to calculate the dfs of the transpose graph */
    public void dfsTranspose(List<Vertex> graph){
        time = 0;
        int i =1;
        for (Vertex u: graph) {
            if(u.getColor().equals("WHITE")){
                System.out.println("\nComponent " + i + ": ");
                dfsVisit(graph, u);
                i++;
            }
        }
    }

    public void dfsVisit(List<Vertex> graph, Vertex u){
        /* Increase the time and set the start time of the vertex */
        time++;
        u.setD(time);
        /* Set the color of the vertex to GRAY */
        u.setColor("GRAY");
        for (Edge e: u.getEdges()) {
            /* For each adjacent vertex of the current vertex perform DFS VISIT if not already visited */
            Vertex v = e.getDestination();
            if(v.getColor().equals("WHITE")){
                v.setParent(u);
                dfsVisit(graph, v);
            }
        }
        /* Set the color of the vertex to be BLACK as all the adjacent vertices have been handled */
        u.setColor("BLACK");
        System.out.printf(u.getName() + "\t");
        /* Set the finish time for the vertex */
        time++;
        u.setF(time);
    }
}
