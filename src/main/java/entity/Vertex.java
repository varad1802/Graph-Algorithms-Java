package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    String name;
    Integer dValue;
    List<Edge> edges;
    Vertex parent;
    Boolean visited;
    Integer d;
    Integer f;
    String color;

    public Vertex(String name, Integer dValue, List<Edge> edges, Vertex parent) {
        this.name = name;
        this.dValue = dValue;
        this.edges = edges;
        this.parent = parent;
        this.visited = false;
        this.color = "WHITE";
    }

    public Vertex(Vertex another){
        this.name = another.getName();
        this.dValue = another.getdValue();
        this.edges = new ArrayList<Edge>();
        this.parent = null;
        this.visited = false;
        this.color = "WHITE";
        this.d = another.getD();
        this.f = another.getF();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getdValue() {
        return dValue;
    }

    public void setdValue(Integer dValue) {
        this.dValue = dValue;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", dValue=" + dValue +
                ", edges=" + edges +
                ", parent='" + (parent==null ? "NIL" : parent.getName()) + '\'' +
                ", visited=" + visited +
                '}';
    }
}
