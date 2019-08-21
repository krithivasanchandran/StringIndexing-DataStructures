package CircularList_DS;

public class CircularNode<T> {
	 
	CircularNode next;
	CircularNode tail;
    T object;
    
    public CircularNode(T inboundObjectData) {
    	this.object = inboundObjectData;
    	next = null;
    	tail = null;
	}
}
