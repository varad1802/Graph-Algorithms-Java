package utils;

import entity.Edge;
import entity.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utility {

    public static List<Vertex> getTranspose(List<Vertex> graph){
        List<Vertex> transpose = new ArrayList<>();
        graph.forEach(v -> {
            v.getEdges().forEach(edge -> {
                Vertex end = new Vertex(v);
                Vertex start = new Vertex(edge.getDestination());
                Integer distance = edge.getDistance();
                /* Reverse the edges of the graph */
                if(!transpose.contains(start)){
                    transpose.add(start);
                } else {
                    start = transpose.get(transpose.indexOf(start));
                }
                if(!transpose.contains(end)){
                    transpose.add(end);
                } else {
                    end = transpose.get(transpose.indexOf(end));
                }
                start.getEdges().add(new Edge(end, distance));
            });
        });
        /* Order the vertices in the decreasing order of finish time */
        Comparator<Vertex> distanceSorter = Comparator.comparing(Vertex::getF).reversed();
        transpose.sort(distanceSorter);
        transpose.forEach(vertex -> {
            vertex.setD(0);
            vertex.setF(0);
        });
        return transpose;
    }
}
