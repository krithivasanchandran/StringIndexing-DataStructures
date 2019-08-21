package CircularList_DS;

import java.util.NoSuchElementException;

import javax.naming.NoInitialContextException;


/*
 * Circular List
 *           head-ptr                                                                                                      tail-ptr                  
 *     -->[ProcessId: 3421] -> [ProcessId: 1000] -> [ProcessId: 5421] -> [ProcessId: 3123] -> [ProcessId: 5123] -> [ProcessId : 2131 ] -
 *    |_________________________________________________________________________________________________________________________________| 
 *
 *  A good example of an application where circular linked list should be used is a timesharing problem 
 *  solved by the operating system.
 *  In a timesharing environment, the operating system must maintain a list of present users and must 
 *  alternately allow each user to use a small slice of CPU time, one user at a time. The operating system 
 *  will pick a user, let him/her use a small amount of CPU time and then move on to the next user, etc.
 *  For this application, there should be no NULL pointers unless there is absolutely no one requesting CPU time.
 */

public class CircularLinkedList {
	
	CircularNode headptr = null;
	CircularNode tailptr = null;

	public void add(Object cds){
		
		CircularNode cnode = new CircularNode(cds);
	    CircularNode temp = headptr;
	    
	    if(temp == null)
	    	throw new NoSuchElementException();
	    else{
	    	while(temp.next != null){
	    		temp = temp.next;
	    	}
	    	temp.next = cnode;
	    	cnode.next = headptr;
	    }
	}
	
	public void addFirst(Object o){
		
		CircularNode cnode = new CircularNode(o);
		CircularNode node = headptr;
		CircularNode shdwTail = tailptr;
		
		cnode.next = node;
		node = cnode;
		shdwTail.next = node;
		
	}
	
	public void addLast(Object o){
		CircularNode cnode = new CircularNode(o);
		CircularNode addlasttempptr = headptr;
		
		while(addlasttempptr.next != null){
			addlasttempptr = addlasttempptr.next;
		}
		
	   addlasttempptr.next = cnode;
	   cnode.next = headptr;
	}
	
	
	/*
	 * Check if given linkedlist is circular or not
	 * Copy headptr and check if you reach headptr again or not.
	 */
	
	public boolean isCircularList(Object o){
		CircularNode circularptr = headptr;
		
		if(circularptr == null)
			throw new NullPointerException();
		
		while(circularptr.next != null){
			if(circularptr.next == headptr) return true;
			else circularptr = circularptr.next;
		}
		
		return false;
	}
	
}
