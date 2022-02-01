package algorithms;

import entity.Vertex;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

    public void findShortestPath(List<Vertex> graph, String startVertex) {
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
                /* Get the adjacent vertices of the current vertex and perform the relaxation on these vertices */
                Vertex destinationVertex = edge.getDestination();
                if(!destinationVertex.getVisited()){
                    if(destinationVertex.getdValue() > u.getdValue() + edge.getDistance()){
                        pq.remove(destinationVertex);
                        destinationVertex.setdValue(u.getdValue() + edge.getDistance());
                        destinationVertex.setParent(u);
                        pq.offer(destinationVertex);
                    }
                }

            });
        }
        /* Output the shortest distance and path of each vertex from the source vertex */
        graph.forEach(vertex -> {
            System.out.println("Vertex: " + vertex.getName());
            System.out.println("Shortest Distance: " + vertex.getdValue());
            Stack<String> stk = new Stack<>();
            stk.push(vertex.getName());
            Vertex parent = vertex.getParent();
            while(parent != null){
                stk.push(parent.getName());
                parent = parent.getParent();
            }
            System.out.printf("Shortest Path: ");
            while(stk.size() != 1){
                System.out.printf(stk.pop() + " --> ");
            }
            System.out.println(stk.pop());
            System.out.println();
        });
    }
}
