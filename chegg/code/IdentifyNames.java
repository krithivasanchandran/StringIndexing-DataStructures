package chegg.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IdentifyNames {

	public static void main(String[] args) {

		String inboundInputFilePath = "C:/Users/krichandran/Desktop/uipath.txt";
        String encodingType = "UTF-8";
        StringBuilder fileContents = new StringBuilder();
		
		try{
			FileInputStream inputStream = new FileInputStream(new File(inboundInputFilePath));
			Scanner s = new Scanner(inputStream,encodingType);
			
			while(s.hasNextLine()){
				String line = s.nextLine();
					fileContents.append(line);
			}
		}catch(FileNotFoundException fexp){
			System.out.println(fexp.getMessage());
		}
		
		/*
		 * Read from the StringBuilder and split each line to individual white spaces 
		 * and check for uppercase character of the start of every string
		 */
		try{
		List<String> namesFound = new ArrayList<String>();
		String s = fileContents.toString();
			String[] individualWords = s.split("\\s+");
			
			int len = individualWords.length;
			int i = 0;
			while(i < len){
				
				if(individualWords[i].length() > 1 ? Character.isUpperCase(individualWords[i].charAt(0)) : false){
					if(i+1 < len && individualWords[i+1].length() > 1 ? Character.isUpperCase(individualWords[i+1].charAt(0)) : false ){
						
						System.out.println("Name Pair found with First character of 2 neighbouring words. ");
						namesFound.add(individualWords[i] + individualWords[i+1]+ ",");
						System.out.println("First name--> " + individualWords[i]);
						System.out.println("Last Name --> " + individualWords[i+1]);
					}
					namesFound.add(individualWords[i] + ",");
				}
				
				i++;
		}
		
		namesFound.parallelStream().forEach((t) -> {
			System.out.println("Names Found --> " + t);
		});
		
	}catch(java.lang.StringIndexOutOfBoundsException ex ){
		System.out.println(ex.getMessage());
	}

}

}