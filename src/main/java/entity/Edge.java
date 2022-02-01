package entity;

import java.util.Objects;

public class Edge {
    Vertex destination;
    Integer distance;

    public Edge(Vertex destination, Integer distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(destination, edge.destination) && Objects.equals(distance, edge.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, distance);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destination=" + destination.getName() +
                ", distance=" + distance +
                '}';
    }
}
