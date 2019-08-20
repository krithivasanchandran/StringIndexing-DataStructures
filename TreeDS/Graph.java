package TreeDS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * Chegg Implementation
 */

public class Graph {
 
	/*
	 * One Dimensional Aray of vertices
	 */
	private String[] vertex;
	
	/*
	 * 2 dimensional array of edges
	 */
	private int[][] edges; 
	
	/*
	 * Total number of vertices;
	 */
	private int noOfVertices;
	
	/*
	 * Constructor
	 * 
	 */
	Graph(){
		noOfVertices = 100;
		vertex = new String[noOfVertices];
		edges = new int[noOfVertices-1][noOfVertices-1];
		
	}
	
	public void TraverseDepthFirstOrder() throws IllegalAccessException{
		Stack<String> backtracking = new Stack<String>();
		Map<String,Boolean> visiteddfsnodes = new HashMap<String,Boolean>();
	
		if(vertex == null)
			throw new IllegalAccessException("No elements exists in the graph hence throwing the error");
		
		int traversals = 0;
		while(traversals <= noOfVertices){
			String dfselement = vertex[traversals];
			if(!visiteddfsnodes.containsKey(dfselement)){
				backtracking.add(dfselement);
			}else{
				System.out.println("Node already visited");
			}
			traversals++;
		}
		
		if(visiteddfsnodes.size() == noOfVertices){
			System.out.println("Bingo Depth First Traversal is finished");
		}
	}
	
	public void BreadthFirstOrder() throws IllegalAccessException{

		PriorityQueue<String> visitednodes =new PriorityQueue<String>();  
		List<String> outgoingnodes = new ArrayList<String>();

		if(vertex == null)
			throw new IllegalAccessException("No elements exists in the graph hence throwing the error");
		
		int traversals = 0;
		for(;traversals<noOfVertices;traversals++){
			String bfsele = vertex[traversals];
			if(!visitednodes.contains(bfsele)){
				outgoingnodes.add(bfsele);
			}else
			{
				visitednodes.add(bfsele);
			}
		}
		
		if(visitednodes.size() == noOfVertices){
			System.out.println("bfs order searched and accomplished");
		}
	}
	
	public void Sort(){
		//Adding the vertices to the collection
		List<String> unsortedVertices = new ArrayList<String>();
		
		for(int i =0 ; i<noOfVertices; i++){
			unsortedVertices.add(vertex[i]);
		}
		
		unsortedVertices.stream().sorted((c1,c2) -> c1.compareTo(c2)).forEach(System.out::println);
	}
	
}
