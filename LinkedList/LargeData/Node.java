package LinkedList.LargeData;

/*
 * A linked list is a linear data structure where each element is a separate object.
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 * 
 */

public class Node {

	String data;
	Node next;
	
	Node(String inbounddata){
		this.data = inbounddata;
		next = null;
	}
}