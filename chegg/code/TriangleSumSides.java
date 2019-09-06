package chegg.code;

import java.util.Scanner;

public class TriangleSumSides {

	public static void main(String[] args) {

		 for(;;){
			 
		 Scanner scanner = new Scanner(System.in);
		 
		  int firstSide = 0;
		  int secondSide = 0;
		  int thirdSide = 0;
		 
		  System.out.println("Please enter the first triangle side");
		  
		  while(scanner.hasNext()){
			  
			  firstSide = scanner.nextInt();
			  
			  System.out.println("Please enter the second side of the triangle");
			  secondSide = scanner.nextInt();
			  
			  System.out.println("Please enter the third side of the triangle");
			  secondSide = scanner.nextInt();
			  
			  break;
		  }
		 
			  if(calculateTraingleSum(firstSide,secondSide,thirdSide)){
				  System.out.println("Success !! the Triangle property is deemed attained");
				  System.exit(0);
			  }else{
				  main(args);
			  }
		  }
	}
	
	/*
	 * Sum of any two sides must be greater than the third side
	 */
	
	public static boolean calculateTraingleSum(int side1 , int side2 , int side3){
		
		if(side1 + side2 > side3) return true;
		else if(side2 + side3 > side1) return true;
		else if(side1 + side3 > side2) return true;
		else{
			System.out.println("Looks like the sum of any two side is not equal to the third side");
			return false;
		}
	}

}