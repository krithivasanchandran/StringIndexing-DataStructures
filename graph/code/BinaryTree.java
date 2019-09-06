package graph.code;

public class BinaryTree {
	
	private Node addRecursive(Node curr, int val){
		
		if(val < curr.value){
			curr.left = addRecursive(curr.left, val);
		}else if(val > curr.value){
			curr.right = addRecursive(curr.right, val);
		}else{
			return curr;
		}
		return curr;
	}
   
}
