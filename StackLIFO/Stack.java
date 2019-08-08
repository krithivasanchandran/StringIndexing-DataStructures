package StackLIFO;

public class Stack {
	
	private int stackSize = Integer.MAX_VALUE;
	String[] stkptr = new String[stackSize/10 - 100];
	
	private int top = -1;
	private String val;
	
	/*
	 * Initializing an empty Stack
	 * With Initial Value as passed 
	 * in the Constructor.
	 */
	
	Stack(String val){
	 	this.val = val;
	 	stkptr[++top] = val;
	}
	
	/*
	 * Stack Underflow Check and poping the 
	 * Top 
	 */
	public String pop(){
		if(top == -1){
			System.out.println("No elements exists in the Stack to pop");
			System.out.println("Stack Underflow Property");
			return null;
		}
			
		String popedStud = stkptr[top];
		--top;
		return popedStud;
	}
	
	/*
	 * Validate for Stack Overflow and 
	 * pushing it to the stack. 
	 */
	
	public void push(String s){
		if(top == stackSize - 1){
			System.out.println("Stack is full !! Stack Overflow !!");
		}else{
			stkptr[++top] = s;
		}
	}

}