package StackLIFO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StackSorting {
	
	public static void main(String args[]){
		
		List<String> heap = new ArrayList<String>();
		heap.add("goodmorning");
		heap.add("goodmorningchennai");
		heap.add("tirunelveli");
		heap.add("madurai");
		heap.add("ramarkovil");
		
		List<String> p = heap.stream().sorted((t1, t2) -> t1.compareTo(t2)).collect(Collectors.toList());
		
		for(String n : p){
			System.out.println(n);
		}
	}
}