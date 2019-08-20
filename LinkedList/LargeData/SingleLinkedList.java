package LinkedList.LargeData;

public class SingleLinkedList<T> {
    T t;
    SingleLinkedList<T> nextptr;
    SingleLinkedList<T> headptr;
    
    public SingleLinkedList(T t) {
    	this.t = t;
    	nextptr = null;
    	headptr = SingleLinkedList.this;
	}
}
