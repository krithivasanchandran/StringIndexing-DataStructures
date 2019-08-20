package LinkedList.LargeData;

public class SingleLinkedListImplementation {
	
	SingleLinkedList<String> root = null;
	
	public SingleLinkedListImplementation() {
		root = new SingleLinkedList<String>("Start");
	}
	
	public void insertNode(String inbound) throws Exception{
		
		if(root == null)
			throw new IllegalArgumentException("Root Of SinglyLinkedList is null");
		
		SingleLinkedList temproot = root;
		
		if(inbound.isEmpty() || inbound == null)
			throw new Exception("Node to be inserted is empty or null");
		
		if(temproot != null){
			SingleLinkedList p = new SingleLinkedList(inbound);
			temproot.nextptr = p;
			p.nextptr = null;
		}
	}
}
