package chegg.code;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * PLEASE PUT ALL CPU TIMES FOR DATA SIZES OF 1000 10000 100000 1 million 10 million
 */

public class ComputeHashSetExperiment {
	
	public static void main(String[] args)  {
		
		Set<Integer> hashSetPerformanceComputation = new HashSet<Integer>();
		
		
		//1000
		insertHashSetComputation(1000,hashSetPerformanceComputation);
		
		//10000
		insertHashSetComputation(10000,hashSetPerformanceComputation);

		//100000
		insertHashSetComputation(100000,hashSetPerformanceComputation);
		
		//1000000
		insertHashSetComputation(1000000,hashSetPerformanceComputation);
		
		//10000000
		insertHashSetComputation(10000000,hashSetPerformanceComputation);
		
	}
	
	static void insertHashSetComputation(int totaldatasetSize, Set<Integer> hashperformance){
		

		long startTime = System.nanoTime();
		int runs = 10000;
		
		Random generator = new Random(totaldatasetSize);
		
		int cnt = 0;
		while(cnt < totaldatasetSize+1){
			hashperformance.add(generator.nextInt());
			cnt++;
		}
		
		System.out.println(" HashSet Currently holding --> " + hashperformance.size());
		
        long time = System.nanoTime() - startTime;
		
		printRunsTime(totaldatasetSize,time,runs);

	}
	
	static void printRunsTime(int dataset,long time,int runs){
		System.out.printf("%d number size dataset took an average of %,d ns%n", dataset,time/runs);
	}


}
