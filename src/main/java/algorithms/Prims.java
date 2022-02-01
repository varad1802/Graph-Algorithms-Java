package algorithms;

import entity.Vertex;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

    public void findMinimumSpanningTree(List<Vertex> graph, String startVertex) {
        /* Set the distance of the start vertex to 0 */
        Vertex start = graph.get(graph.indexOf(new Vertex(startVertex, 0, null, null)));
        start.setdValue(0);
        graph.set(graph.indexOf(start), start);
        Comparator<Vertex> distanceSorter = Comparator.comparing(Vertex::getdValue);
        /* Add the vertices in the priority queue ordered by the d-value of the vertices */
        PriorityQueue<Vertex> pq = new PriorityQueue<>(distanceSorter);
        pq.addAll(graph);
        while(!pq.isEmpty()){
            /* Get the minimum value vertex from the priority queue */
            Vertex u = pq.poll();
            u.setVisited(true);
            u.getEdges().forEach(edge -> {
                /* Get the adjacent vertices of the current vertex and the keys for these vertices */
                Vertex destinationVertex = edge.getDestination();
                if(!destinationVertex.getVisited()){
                    if(destinationVertex.getdValue() > edge.getDistance()){
                        pq.remove(destinationVertex);
                        destinationVertex.setdValue(edge.getDistance());
                        destinationVertex.setParent(u);
                        pq.offer(destinationVertex);
                    }
                }
            });

        }
        int totalCost = 0;
        /* Output the edges included and the total cost of the minimum spanning tree */
        for(Vertex vertex : graph){
            if(vertex.getParent() != null){
                System.out.println("Edge: " + vertex.getParent().getName() + " - " + vertex.getName() + "\t\tCost: " + vertex.getdValue());
                totalCost += vertex.getdValue();
            }
        }
        System.out.println("\nTotal Cost of Spanning Tree: " + totalCost);
    }


}
