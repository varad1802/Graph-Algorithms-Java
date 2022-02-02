# Graph-Algorithms-Java
Implementation of graph algorithms for directed and undirected graphs. This project was a part of Data structures and algorithms coursework under the guidance of Dr. Dewan Ahmed.<br /><br />
The project includes following algorithm implementations:
* ### Single Source Shortest Path: **Dijkstra's Algorithm**
* ### Minimum Spanning Tree: **Prim's Algorithm**
* ### Finding Strongly Connected Components: **Kosaraju's Algorithm**

## Prerequisites:
* Make sure you have Java Installed.
* Make sure you have Maven installed.

## Graph Format:
The graph given as input will be of the following format: <br />
![alt text](https://user-images.githubusercontent.com/34937940/152195825-f74cec4c-0dee-4eba-b43e-c5dbfb60d005.png)


Here, the first two numbers represent the number of vertices and edges. The letter U stands for undirected graph (D for directed). 
From the second line, it mentions all edges and its weight (e.g. 𝑒𝑑𝑔𝑒(𝐴,𝐵) and its weight is 1. 
The last line is optional. If given, it represents the source node.

## Steps to run the code:
1. Download and unzip GraphImplementations.zip. It contains the implementation of all the algorithms.
2. Download and unzip Graphs.zip. It contains the graph inputs. The file has 4 undirected graphs, 2 directed graphs and 4 directed(Acyclic) graphs for the SCC algorithm.
3. To run the code, open the terminal in the GraphImplementation folder and type the following command:<br />
**```java -jar target/GraphImplementations-1.0-SNAPSHOT-jar-with-dependencies.jar  <path-to-the-graph-text-file>```**
4. For example,<br />
**```java -jar target/GraphImplementations-1.0-SNAPSHOT-jar-with-dependencies.jar /Users/user/downloads/Undirected1.txt```**
5. Based on the type of graph the program will tell you to select the type of operation you want to perform.
6. For undirected graph, you can do the following:
   * Find single source shortest path
   * Find minimum spanning tree
7. For directed graph, you have the following:
   * Find single source shortest path
   * Find strongly connected components in the graph
8. Input your choice and the program will get executed. Check the output.

## Troubleshooting:
* If you have an error running the jar, you can rebuil;d the jar using the following command: **```maven clean install```**
* Once the build is successful, you can re-run the jar

