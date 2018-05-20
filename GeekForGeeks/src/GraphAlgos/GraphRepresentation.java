package GraphAlgos;

import java.util.LinkedList;

public class GraphRepresentation{
	
	static class Graph{
		int V;
		LinkedList<Integer> adjListArray[];
	
 
	Graph(int V){
		this.V = V;
	    adjListArray = new LinkedList[V];
	    
	    for(int i = 0; i < V; i++){
	    	adjListArray[i] = new LinkedList<>();
	    	
	    }
	}
	
	}
	static void addEgde(Graph graph, int src, int dest){
		graph.adjListArray[src].addFirst(dest);
		graph.adjListArray[dest].addFirst(src);
	}
	
	static void printGraph(Graph graph){
		
		for(int v = 0; v < graph.V; v++){
			
			System.out.println("Adjacency List of vertex " + v);
			System.out.print("head");
			
			for(Integer pcrawl: graph.adjListArray[v]){
				System.out.print("->" + pcrawl);
			}
			System.out.println("\n");
		}
		
	}


	public static void main(String args[]){
		
	}
	
}
