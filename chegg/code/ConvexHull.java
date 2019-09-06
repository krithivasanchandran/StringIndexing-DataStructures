package chegg.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConvexHull {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\{user}\\Desktop\\input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null){ 
		    System.out.println(" Reading line -> " + st); 
		  } 
		  
		  String[] rawinput = st.split("s+");
		  
		  Scanner scanner = new Scanner(System.in);
		  
		  int firstInput = 0;
		  int secondInput = 0;
		  
		  while(scanner.hasNext()){
			  System.out.println("Please enter the first input number");
			  firstInput = scanner.nextInt();
			  System.out.println("Please enter the second input number");
			  secondInput = scanner.nextInt();
			  break;
		  }
		  
		  
		  if(rawinput.length ==0){
			  if(firstInput > secondInput){
				  System.out.println("Inside");
			  }else{
				  System.out.println("Outside");
			  }
		  }else{
			  for(int i=0;i<rawinput.length;i++){
				  
				  switch(i)
				  {
				  case 0:
					  firstInput = Integer.parseInt(rawinput[i]);
					  break;
					  
				  case 1: 
					  secondInput = Integer.parseInt(rawinput[i]);
					  break;
				  }
			  }
			  
			  if(firstInput > secondInput){
				  System.out.println("Inside");
			  }else{
				  System.out.println("Outside");
			  }
		  }
		  

	}

}
