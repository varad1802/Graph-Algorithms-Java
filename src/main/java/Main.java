import algorithms.Dijkstra;
import algorithms.Prims;
import algorithms.SCC;
import entity.Edge;
import entity.Vertex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("Please provide the Graph file location as an input");
            System.exit(1);
        }

        String graphFile = args[0];
        Integer vertices;
        Integer edges;
        String graphType;
        String startVertex;
        List<Vertex> graph = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(graphFile)))) {
            String line;
            line = br.readLine();
            if(line != null){
                String params[] = line.split(" ");
                if(params.length < 3){
                    System.out.println("Not enough parameters");
                    System.exit(1);
                }

                vertices = Integer.valueOf(params[0]);
                edges = Integer.valueOf(params[1]);

                graphType = params[2];
                int count = 0;
                if(graphType.equals(String.valueOf('U'))){
                    System.out.println("The Graph provided is undirected Graph");
                    Vertex v;
                    Vertex u;
                    while ((line = br.readLine()) != null && count < edges.intValue()) {
                        String node[] = line.split(" ");
                        v = new Vertex(node[0], Integer.MAX_VALUE, new ArrayList<Edge>(), null);
                        u = new Vertex(node[1], Integer.MAX_VALUE, new ArrayList<Edge>(), null);
                        if(!graph.contains(u) && !graph.contains(v)){
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            u.getEdges().add(new Edge(v, Integer.valueOf(node[2])));
                            graph.add(v);
                            graph.add(u);
                        } else if(graph.contains(u) && graph.contains(v)){
                            v = graph.get(graph.indexOf(v));
                            u = graph.get(graph.indexOf(u));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            u.getEdges().add(new Edge(v, Integer.valueOf(node[2])));
                        } else if(!graph.contains(u) && graph.contains(v)){
                            v = graph.get(graph.indexOf(v));
                            u.getEdges().add(new Edge(v, Integer.valueOf(node[2])));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            graph.add(u);
                        } else {
                            u = graph.get(graph.indexOf(u));
                            u.getEdges().add(new Edge(v, Integer.valueOf(node[2])));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            graph.add(v);
                        }
                        count ++;
                    }
                } else {
                    System.out.println("The Graph provided is directed Graph");
                    Vertex v;
                    Vertex u;
                    while ((line = br.readLine()) != null && count < edges.intValue()) {
                        String node[] = line.split(" ");
                        v = new Vertex(node[0], Integer.MAX_VALUE, new ArrayList<Edge>(), null);
                        u = new Vertex(node[1], Integer.MAX_VALUE, new ArrayList<Edge>(), null);
                        if(!graph.contains(u) && !graph.contains(v)){
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            graph.add(v);
                            graph.add(u);
                        } else if(graph.contains(u) && graph.contains(v)){
                            v = graph.get(graph.indexOf(v));
                            u = graph.get(graph.indexOf(u));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                        } else if(!graph.contains(u) && graph.contains(v)){
                            v = graph.get(graph.indexOf(v));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            graph.add(u);
                        } else {
                            u = graph.get(graph.indexOf(u));
                            v.getEdges().add(new Edge(u, Integer.valueOf(node[2])));
                            graph.add(v);
                        }
                        count ++;
                    }
                }
                if (count < edges){
                    System.out.println("No of edges provided do not match");
                    System.exit(1);
                }

                String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                while(graph.size() < vertices){
                    char letter = abc.charAt(new Random().nextInt(abc.length()));
                    Vertex v = new Vertex( Character.toString(letter), 0, new ArrayList<Edge>(), null);
                    if(!graph.contains(v))
                        graph.add(v);
                }

                if(line != null){
                    startVertex = line;
                } else {
                    //System.out.println(Sta);
                    startVertex = graph.get(new Random().nextInt(graph.size())).getName();
                }
                Scanner sc = new Scanner(System.in);
                if(graphType.equals(String.valueOf('U'))) {
                    System.out.println("Please select the action for undirected graph:");
                    System.out.println("1. Calculate single source shortest path using Dijkstra's algorithm");
                    System.out.println("2. Calculate Minimum spanning tree using Prim's algorithm");
                    System.out.println("Enter your choice: ");
                    int choice = sc.nextInt();
                    if(choice == 1) {
                        System.out.println("Calculating shortest paths from starting vertex: " + startVertex);
                        new Dijkstra().findShortestPath(graph, startVertex);
                    } else {
                        System.out.println("Calculating minimum spanning tree from starting vertex: " + startVertex);
                        new Prims().findMinimumSpanningTree(graph, startVertex);
                    }
                } else {
                    System.out.println("Please select the action for directed graph:");
                    System.out.println("1. Calculate single source shortest path using Dijkstra's algorithm");
                    System.out.println("2. Find Strongly Connected Components for the given Digraph");
                    System.out.println("Enter your choice: ");
                    int choice = sc.nextInt();
                    if(choice == 1) {
                        System.out.println("Calculating shortest paths from starting vertex: " + startVertex);
                        new Dijkstra().findShortestPath(graph, startVertex);
                    } else {
                        System.out.println("Calculating strongly connected components for the given graph");
                        new SCC().stronglyConnected(graph);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
