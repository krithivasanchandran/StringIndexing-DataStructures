package graph.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private static int rows = 5;
	private static int columns = 5;
	
	int adj[][] = new int[rows][columns];
	
	Graph(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				
				if(i==0 && j == 0){
					adj[i][j] = 0;
				}else if(i == 0 && (j == 2 || j == 3) ){
					adj[i][j] = 0;
				}else if(i == 1 && j == 1){
					adj[i][j] = 0;
				}else if(i == 2 && (j == 0 || j == 2 || j == 4) ){
					adj[i][j] = 0;
				}else if(i == 3 && (j == 0 || j == 3)){
					adj[i][j] = 0;
				}else if(i == 4 && (j == 2 || j == 4)){
					adj[i][j] = 0;
				}else{
					adj[i][j] = 1;
				}
				
			}
		}
	}
	
	public void adjList(){
		List<LinkedList> adjacencyList = new ArrayList<LinkedList>();
		
		for(int k=0;k<adjacencyList.size();k++){
			
			switch(k)
			{
			case 0: 
				LinkedList<String> nodes = adjacencyList.get(k);
				nodes.addFirst("4");
				nodes.addFirst("1");
				nodes.addLast("/");
			    break;
			   
			case 1: 
				LinkedList<String> nodes_1 = adjacencyList.get(k);
				nodes_1.addFirst("3");
				nodes_1.addFirst("2");
				nodes_1.addFirst("4");
				nodes_1.addFirst("0");
				nodes_1.addLast("/");
			    break;
			    
			case 2: 
				LinkedList<String> nodes_2 = adjacencyList.get(k);
				nodes_2.addFirst("3");
				nodes_2.addFirst("1");
				nodes_2.addLast("/");
				break;
			
			case 3: 
				LinkedList<String> nodes_3 = adjacencyList.get(k);
				nodes_3.addFirst("2");
				nodes_3.addFirst("4");
				nodes_3.addFirst("1");
				nodes_3.addLast("/");
				break;
				
			case 4: 
				LinkedList<String> nodes_4 = adjacencyList.get(k);
				nodes_4.addFirst("1");
				nodes_4.addFirst("0");
				nodes_4.addFirst("3");
				nodes_4.addLast("/");
				break;
				
			default :
				System.out.println("In the default case");
			}
		}
		
		LinkedList<String> nodes = adjacencyList.get(0);
		
		LinkedList<Integer> adj = new LinkedList<Integer>();
		
	}

}
