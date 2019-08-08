package StackLIFO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackCallable {
	
	public static void main(String args[]) {
		
		int dataSize = 1024 * 1024;

        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		System.out.println("Initial Memory During Start of Program Execution :" + beforeUsedMem/dataSize + "MB");
		
		String inboundInputFilePath = "C:/Users/krichandran/Documents/LargeFile-Reading-Dump-File/enwik9/enwik9";

		int insertCnt = 0;
		
		StringBuilder largeInBoundFileContents = new StringBuilder();
		Stack stck = new Stack("Starthere");

		try{
			FileInputStream inputStream = new FileInputStream(new File(inboundInputFilePath));
			Scanner s = new Scanner(inputStream,"UTF-8");
			
			while(s.hasNextLine()){
				String line = s.nextLine();
				if(!line.isEmpty() || line.length() != 0){
					stck.push(line);
				}
				insertCnt = insertCnt + 1;
				if(insertCnt == 100000) break;
			}
		}catch(FileNotFoundException fexp){
			fexp.printStackTrace();
		}
		
		String str = null;
		
		while( (str = stck.pop()) != null){
			System.out.println("Poped Element ------> " + str);
		}
		
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		System.out.println(" End of Program - Trie - Of program Execution : " + afterUsedMem/dataSize + "MB");
		
		long actualMemUsed=afterUsedMem-beforeUsedMem;

		System.out.println("Actual Memory Used :: Trie :: Suffix Lookup and Search : HashMap : =>" + actualMemUsed/dataSize + "MB");
	}

}
