package GraphAlgos;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFS {

	int V;
	LinkedList adjArrayList[];
	
	public BreadthFS(int V){
		this.V = V;
		adjArrayList = new LinkedList[V];
	
	for(int i = 0; i < V; i++){
		adjArrayList[i] = new LinkedList<Integer>();		
	}
	}
	public void addEgde(int src, int dest){
		
		adjArrayList[src].addFirst(dest);
		
	}
	
	public void BFS(int s){
		
		boolean visited[] = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s] = true;
		queue.offer(s);
		
		while(queue.size() != 0){
			
			s = queue.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i = adjArrayList[s].listIterator();
			while(i.hasNext()){
				
				int n = i.next(); 
				if(!visited[n]){
					visited[n]= true;
					queue.offer(n);
				}
				
				
			}
			
		}
		
	}
	
	public static void main(String arg[]){
		
	}
	
}
