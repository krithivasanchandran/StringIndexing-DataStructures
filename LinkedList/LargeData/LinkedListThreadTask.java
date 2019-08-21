package LinkedList.LargeData;

public class LinkedListThreadTask implements Runnable{
	
	private String name;
	
	public LinkedListThreadTask(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void run(){
		SinglyLinkedList sl = new SinglyLinkedList("firstElement ");

		sl.appendElement("-> secondElement ");
		sl.appendElement("-> thirdElement ");
		sl.appendElement("-> fourthElement ");
		sl.appendElement("-> FifthElement ");
		sl.appendElement("-> sixthElement ");
		sl.appendElement("-> seventhElement ");

		for (int i = 0; i < 10000; i++) {
			sl.appendElement("-> xElements " + i + "");
		}
		
		System.out.println("LkList is Empty -----> " + sl.isEmpty());

		sl.addFirst("Test::FirstElement::AddFirstMethod");
		sl.addLast("Test::LastElement::AddLastMethodTesting");

		System.out.println("Printing the LastMethod Add ====> " + sl.toString());
		System.out.println(" First LKList node ---> " + sl.getFirst());
		System.out.println(" Last LkList node -----> " + sl.getLast());

		sl.removeFirst();

		System.out.println("Removed First :: ==> " + sl.getFirst());
		System.out.println("Printing :: the list After Removing First Element ===> " + sl.toString());

		sl.removeLast();

		System.out.println("Printing :: Removing Last Element --> " + sl.toString());

		String searchTerm = "-> sixthElement ";
		int index = sl.search(searchTerm);

		System.out.println(" The searched Term is in index --> " + index);
	}
}
