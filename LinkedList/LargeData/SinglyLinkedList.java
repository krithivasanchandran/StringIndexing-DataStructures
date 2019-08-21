package LinkedList.LargeData;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A linked list is a dynamic data structure. The number of nodes in a list is not fixed and 
 * can grow and shrink on demand. Any application which has to deal with an unknown number of 
 * objects will need to use a linked list.
 * One disadvantage of a linked list against an array is that it does not allow direct access 
 * to the individual elements. If you want to access a particular item then you have to start 
 * at the head and follow the references until you get to that item.
 */

public class SinglyLinkedList {
	
	private static final String EmptyList = "Singly LinkedList is Empty";

	/*
	 * If List is empty : The entry points to First Node.
	 */
	Node head = null;
	
	
	public SinglyLinkedList(String inboundData) {
		Node f_n = new Node(inboundData);
		f_n.next = null;
	    head = f_n;
	}
	
	public boolean isEmpty(){ return head == null ? true : false;}
   
	public String getFirst(){ 
		if(head == null)
			throw new NoSuchElementException();
		else
			return head.data;
	}
	
	public String getLast(){
		if(head == null)
			throw new NoSuchElementException();
		else{
			Node last = head;
			while(last.next != null){
				last = last.next;
			}
			return last.data;
		}
			
	}
	
	public void appendElement(String s){
		
		Node n = new Node(s);
		Node aota = head;
		
		if(aota == null){
		
			aota = n;
			n.next = null;
			
			System.out.println("Inside the aota is NULL ::::::: ");
			
		}else{
			while(aota.next != null){
				aota = aota.next;
			}
			
			aota.next = n;
			n.next = null;
		}
	}
	
	/*
	 * O(1) Operation.
	 */
	
	public void addFirst(String s){
		
		Node firstNode = new Node(s);
		Node firstShdwCopy = head; 
		
		if(head == null){
			
			System.out.println("LinkedList is already Empty ! Creating the first  node");
			firstShdwCopy = firstNode;
			
		}else{
			
			/*
			 * Assuming headptr is pointing to the start node of the LinkedList.
			 */
			Node t = firstShdwCopy;
			firstShdwCopy = firstNode;
			firstShdwCopy.next = t;
		}
	}
	
	/*
	 * O(1) Operation - Add Last.
	 */
	
	public void addLast(String s){
		Node lastnode = new Node(s);
		Node temp = head;
		if(head == null){
			addFirst(s);
		}else{
			
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = lastnode;
			temp = temp.next;
		}
	}
	
	/*
	 * Deleting all nodes
	 */
	
	public void deleteAll(){
		head = null;
	}
	
	/*
	 * O(1) Operation - Removing first nodes
	 */
	
	public void removeFirst(){
		Node removedHead = head;
		head = head.next;
		removedHead = null;
	}
	
	/*
	 * O(1) Operation - Removing Last nodes.
	 */
	public void removeLast(){
        Node cloneH = head;
        Node holdPreviousRef = null;
        while(cloneH.next != null){
        	if(cloneH.next.next == null){
        		holdPreviousRef = cloneH.next;
        	}
        	cloneH = cloneH.next;
        }
        if(holdPreviousRef != null){
        	cloneH = null;
        	holdPreviousRef.next = null;
        }
	}
	
	/*
	 * O(n) operation 
	 * Result : -1 : Means it is not found.
	 */
	
	public int search(String searchTerm){
		Node c = head;
		int index = 0;
		
		while(c.next != null){
			if(c.data.equalsIgnoreCase(searchTerm)) return index;
			c = c.next;
			index++;
		}
	
		return -1;
	}
	
	/* O(n)
	 * Retrieve an element at a given Index Position
	 */
	public String get(int pos){
		if(pos == -1)
			throw new NoSuchElementException();
		
		Node indexptr = head;
		
		if(head == null)
			throw new NoSuchElementException(EmptyList);
		
		int cnt =0;
		while(cnt < pos){
			indexptr = indexptr.next;
			cnt++;
		}
		
		return indexptr.data;
	}
	
	public void InsertAfter(int pos, String val){
		Node j = head;
		Node oneptrNodeAdvance = j.next; 
		int cnt = 0;
		
		while(cnt <= pos && j.next.next != null){
			if(cnt == pos) break;
			j = j.next;
			oneptrNodeAdvance = j.next;
			cnt ++;
		}
		
		Node new_insert = new Node(val);
		j.next = new_insert;
		new_insert = oneptrNodeAdvance;
	}
	
	
	public void insertBefore(int pos,String val){
		
		Node ibefore = new Node(val);
		Node p = head;
		Node curr = null;
		
		int cnt = 0;
		
		while(cnt <= pos ){
			curr = p;
			p = p.next;
			if(cnt == pos) break;
				
				cnt++;
		}
		
		curr.next = ibefore;
		ibefore.next = p;
	}
	
	public void remove(String key){
		if(head == null)
			throw new RuntimeException("cannot delete");
		
		if(head.data.equalsIgnoreCase(key)){
			head = head.next;
			return; 
		}
		
		Node curr = head;
		Node prev = null;
		
		while(curr != null && !curr.data.equalsIgnoreCase(key)){
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null) throw new RuntimeException("cannot delete");
		
		prev.next = curr.next;
	}
	
	public String toString(){
		Node shadow = head;
		StringBuilder linkedPrinter = new StringBuilder();
		
		while(shadow.next != null){
			linkedPrinter.append(shadow.data);
			shadow = shadow.next;
		}
		
		return linkedPrinter.toString();
	}
	
	public Iterator iterator(){
		return new LinkedListIterator();
	}
	
     class LinkedListIterator implements Iterator{

		private Node nextNode;

	    public LinkedListIterator() {
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public Object next() {
	         if (!hasNext()) throw new NoSuchElementException();
	         String res = nextNode.data;
	         nextNode = nextNode.next;
	         return res;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
