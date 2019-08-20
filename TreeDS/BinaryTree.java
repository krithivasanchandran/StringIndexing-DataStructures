package TreeDS;

import java.util.Comparator;

public class BinaryTree {
	
	Btree headptr = null;
	
	public void insert(int inboundData){
		
	   if(inboundData == 0)
		   throw new IllegalArgumentException("InValid Input");
	   
	   if (headptr == null){
		   Btree btree = new Btree(10);
		   headptr = btree;
		   
	   }else{
		   for(;!headptr.isLeaf;){
		   if(inboundData < headptr.left.data && !headptr.isLeaf)  moveLeft();
		   else if(inboundData > headptr.right.data && !headptr.isLeaf) moveRight();
		   else {
			   Btree insertN = new Btree(inboundData);
			   headptr = insertN;
			   headptr.isLeaf = true;
			   break;
		   }
		   }
	   }
	}
	
	public Btree moveLeft(){
		if(headptr == null) throw new IllegalArgumentException("Head pointer is null => Either the Tree is empty or not null");
		return headptr.left;
	}
	
	public Btree moveRight(){
		if(headptr == null) throw new IllegalArgumentException("Head pointer is null => Either the Tree is empty or not null");
		return headptr.right;
	}
	
	public boolean Search(int d){
		while(!headptr.isLeaf){
			if(d < headptr.data) headptr = moveLeft();
			else if(d > headptr.data) headptr = moveRight();
			else{
				return ( d == headptr.data) ? true : false;
			}
		}
		return false;
	}
	
	public boolean isBalanced(){
		int leftHeight = 0;
		int RightHeight = 0;
		
		while(!headptr.isLeaf){
			moveLeft();
			leftHeight++;
		}
		
		while(!headptr.isLeaf){
			moveRight();
			RightHeight++;
		}
		
		return leftHeight == RightHeight;
	}

	
	 public int minVal(){
		Btree t = headptr;
		while(!t.isLeaf){
			t = t.left;
		}
		return t.data;
	 }
	 
	 public int MaxVal(){
		 Btree shdwptr = headptr;
		 while(!shdwptr.isLeaf){
			 shdwptr = shdwptr.right;
		 }
		 return shdwptr.data;
	 }
	 
	 public void printTree(Btree t)
	 {
		 Btree tree = headptr;
		 if(tree == null) 
			 System.out.println("Tree is empty cannot be printed !! ");
		 else
			 System.out.println(tree.data);
		 
		 printTree(tree.left);
		 printTree(tree.right);
		 
	 }
}
