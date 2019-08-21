package LinkedList.LargeData;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * Calls the Singly Linked List Implementation
 */
public class Callable {

	public static void main(String[] args) {

		int dataSize = 1024 * 1024;

		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println("Initial Memory During Start of Program Execution :" + beforeUsedMem / dataSize + "MB");

		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		for(int i=1;i<=20;i++){
			LinkedListThreadTask t = new LinkedListThreadTask("LinkedList Thread "+ i);
			System.out.println("Created :: " + t.getName());
			executor.execute(t);
		}
		
		executor.shutdown();
		
		
		long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println(
				" End of Program - SinglyLinkedList - Of program Execution : " + afterUsedMem / dataSize + "MB");

		long actualMemUsed = afterUsedMem - beforeUsedMem;

		System.out.println("Actual Memory Used :: SingleLinkedList :: Appending New Element : =>"
				+ actualMemUsed / dataSize + "MB");
	}

}
