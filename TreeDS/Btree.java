package TreeDS;

public class Btree {
	
	Btree left;
	Btree right;
	int data;
	boolean isLeaf;
	
	Btree(int val){
		data = val;
		left = null;
		right = null;
	}
}