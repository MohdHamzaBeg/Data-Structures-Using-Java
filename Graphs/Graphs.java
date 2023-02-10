import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Graphs are really good in catching arbitary high value relationship.
 * Applications- social media graph related APIs, google maps
 * Graphs are the data sturcture which consists of a collection of nodes/vertices
 * and a collection of edges/paths
 * 
 * Using the adjancancy list in graphs:-
 * It is an array of arraylist of pairs in which each index is denoted as the vertex of graph
 * and those index stores a list of pair of vertex with which the index vertex is connected 
 * and the weight which the edge bear.
 * For an unweighted graph, only the vertex is stored and not the weight
 * The arraylist must be prepared by keeping in mind whether the edge is directed or
 * undirected.
 * */
class Index {
    int src;
    int dest;

    public Index(int source, int destination) {
        this.src = source;
        this.dest = destination;
    }
}

public class Graphs {

    private static ArrayList<ArrayList<Index>> build(int n) {
        ArrayList<ArrayList<Index>> graph = new ArrayList<ArrayList<Index>>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<Index>()); // Initialising the Inside arraylist
                                                // with an empty value
        }
        // Concept-- To add the adjacent nodes of a source node, we must get to a
        // particular index number which is already initialised and then add our sublist
        graph.get(0).add(new Index(0, 1));
        //graph.get(0).add(new Index(0, 2));

       // graph.get(1).add(new Index(1, 0));
        graph.get(1).add(new Index(1, 2));
        //graph.get(1).add(new Index(1, 3));
        graph.get(1).add(new Index(1, 4));

        //graph.get(2).add(new Index(2, 0));
        //graph.get(2).add(new Index(2, 1));
        graph.get(2).add(new Index(2, 3));
        graph.get(2).add(new Index(2, 4));

        //graph.get(3).add(new Index(3, 1));
        //graph.get(3).add(new Index(3, 2));
        //graph.get(3).add(new Index(3, 4));

        //graph.get(4).add(new Index(4, 2));
        //graph.get(4).add(new Index(4, 3));

        return graph;
    }

    private static void display(ArrayList<ArrayList<Index>> graph, int n) {
        ArrayList<Index> brr = new ArrayList<Index>();
        for (int i = 0; i < n; i++) {
            brr = graph.get(i);
            for (int j = 0; j < brr.size(); j++) {
                System.out.println(brr.get(j).src + " -> " + brr.get(j).dest);
            }
        }
    }

    private static void prblm1(ArrayList<ArrayList<Index>> graph, int n, int s, int d) {
        ArrayList<Index> vertex = new ArrayList<Index>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        int i = 0;
        while (i<graph.size()) {
            vertex = graph.get(s);
            System.out.print(s+" -> ");
            for (int j = 0; j < vertex.size(); j++) {
                if (vertex.get(j).dest==d) {
                    System.out.print(d);
                    System.exit(0);
                }
            }
            s = vertex.get(0).dest;
            i++;
        }
    }

    private static void bfs(ArrayList<ArrayList<Index>> graph, int n) {
        ArrayList<Index> brr = new ArrayList<Index>();
        ArrayList<Integer> printedelements = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(graph.get(0).get(0).src);
        printedelements.add(graph.get(0).get(0).src);
        // System.out.println(queue.peek());
        for (int i = 0; i < n; i++) {
            brr = graph.get(queue.peek());
            for (int j = 0; j < brr.size(); j++) {
                if (printedelements.contains(brr.get(j).dest)) {
                    // System.out.println("checkerrr");
                } else {
                    queue.add(brr.get(j).dest);
                    printedelements.add(brr.get(j).dest);
                }
            }
            System.out.println(queue.remove());
        }
    }

    static ArrayList<Integer> printedelements = new ArrayList<Integer>();
    //static int i=0;
    private static void dfs(ArrayList<ArrayList<Index>> graph, int n, int i) {
        for (int j = 0; j < graph.get(i).size(); j++) {
            int neighbour = graph.get(i).get(j).dest;
            if (printedelements.contains(neighbour)) {
                continue;
            }
            printedelements.add(neighbour);
            System.out.println(neighbour);
            if (i<n) {
                dfs(graph, n, neighbour);  
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Index>> graph = new ArrayList<ArrayList<Index>>();
        int n = 5;
        graph = build(n);
        // display(arr, n);
        // bfs(arr, n);
        //dfs(graph, n, 0); // i is passed as the starting point

        // In this file, the design of the graph is changed according the question
        // Problem 1- To check whether there is exist a path between 2 vertices or not
         prblm1(graph,n , 0, 4);
    }
}