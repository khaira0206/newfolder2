package GraphAlgos;

import java.util.List;

public abstract class Graph<T> implements GraphInterface{
	
	int V;
	List<T> adjArrayList[];
	
	abstract List<T>[] createAL(String type);
	abstract List<T> createL(String type);
	
	Graph(int V, String str){
		this.V = V;
		adjArrayList = createAL(str);
		
		for(int i = 0; i <= V; i++){
			
			adjArrayList[i] = createL(str);
		}
	}

}
