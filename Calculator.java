//Chris Cullati
//Comp 310 Professor Assiter

package Assignment2;

import java.util.*;
public class Calculator<E> implements CalculatorInterface<E> {
	private int topIndex = -1;
	private int capacity;
	public static final int CAPACITY = 1000;
	private E[] stack;
	private static final String operators = "-+/*";
    private static final String operands = "0123456789";
	
	//Default constructor
	public Calculator(){
		this(CAPACITY);
	}
	
	//Constructor for specified stack
	public Calculator(int cap){
		capacity = cap;
		stack = (E[]) new Object[capacity];
	}
	
	
	//Returns the size of the stack
	public int size() {
		return (topIndex + 1);
	}

	//Checks whether the stack is empty or not
	public boolean isEmpty() {
		return (topIndex < 0);
	}

	//Clears the stack until its empty
	public void clear(){
		while(!isEmpty()){
			pop();
		}
	}
	
	//Pops the top element off the stack
	public E pop() {
		E element;
		if(isEmpty())
			return null;
		element = stack[topIndex];
		stack[topIndex--] = null;
		return element;
	}

	//Adds elements on top of the stack
	public void push(E element) {
		if(size() != capacity)
			stack[++topIndex] = element;
	}
	
	//shows node of top of stack
	public E peek(){
		
	if(isEmpty())
		return null;
	return stack[topIndex];
	}
	
	//evaluates string expression based on operator
	public int evaluatePostfix(String postfixExpr) {
        char[] chars = postfixExpr.toCharArray(); //converts string to array of character
        Calculator<Integer> stack = new Calculator<Integer>();
        for (char c : chars) {
                if (isOperand(c)) { //checks for number
                        stack.push(c - '0'); // convert char to int val
                } else if (isOperator(c)) { //checks for operator
                        int op1 = stack.pop();
                        System.out.print("Operator 1: " + op1 + "\n");
                        int op2 = stack.pop();
                        System.out.print("Operator 2: " + op2 + "\n");
                        int result;
                        switch (c) {
                        case '*':	//evaluates multiplication
                                result = op1 * op2;
                                stack.push(result);
                                break;
                        case '/':	//evaluates division
                                result = op2 / op1;
                                stack.push(result);
                                break;
                        case '+':	//evaluates addition
                                result = op1 + op2;
                                stack.push(result);
                                break;
                        case '-':	//evaluates subtraction
                                result = op2 - op1;
                                stack.push(result);
                                break;
                        }
                }
        }
        return stack.pop();	//returns answer
	}
	
	private boolean isOperator(char val) {
        return operators.indexOf(val) >= 0; //checks whether character is a operator
	}

	private boolean isOperand(char val) {
        return operands.indexOf(val) >= 0;	//checks whether character is a number
	}
	
	//converts string from infix to postfix
	public static String convertToPostfix(String infix){
		StringBuilder postfix = new StringBuilder();
		CalculatorInterface<Character> operatorStack = new Calculator<Character>();
		int characterCount = infix.length();
		char topOperator;
		
		System.out.print("In convertToPostfix, the input is: " + infix + ".\n"); //shows infix expression
		for (int index = 0; index<characterCount; index++){
			
			boolean done = false;
			char nextCharacter = infix.charAt(index);
			if (isNumber(nextCharacter)) //checks whether character is a number
				postfix = postfix.append(nextCharacter); //adds number to stack
			else {
				switch(nextCharacter){
				case '+': case '-': case '*': case '/':
					while(!done && !operatorStack.isEmpty()){	//uses order of operations to calculate
						topOperator = operatorStack.peek();
						if(getPrecedence(nextCharacter)<=getPrecedence(topOperator)){
							postfix = postfix.append(topOperator);
							operatorStack.pop();
						}
						else done = true;
					}
					operatorStack.push(nextCharacter);
					break;
					
				case '(':
					operatorStack.push(nextCharacter);
					break;
					
				case ')':
					topOperator = operatorStack.pop();
					while(topOperator != '(') {
						postfix = postfix.append(topOperator);
						topOperator = operatorStack.pop();
					}
					break;
				default:
					break;
				}
			}	
		}
		while(!operatorStack.isEmpty()){
			topOperator = operatorStack.pop();
			postfix = postfix.append(topOperator);
		}
		return postfix.toString();	//returns string of postfix expression
	}
	
	//returns precedence number based on order of operations
	private static int getPrecedence(char operator){	
		
		switch(operator){
			case '(':
			case ')':
				return 0;
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
		}
		return -1;
		
	}
	
	//checks whether char is a number
	private static boolean isNumber(char character){
		return Character.isDigit(character);
	}
	
	

	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		
		String pointOperator = "";
		char c = ' ';
		
		Calculator<Character> operator = new Calculator<Character>();
		
		System.out.print("C < Q /\n");	//prints calculator
		System.out.print("7 8 9 *\n");
		System.out.print("4 5 6 -\n");
		System.out.print("1 2 3 +\n");
		System.out.print("0 ( ) =\n");
		
		while(c != 'Q' || c != 'q'){
			pointOperator += keyboard.next(); //adds to string
			for(int i=0;i<pointOperator.length();i++){
				c = pointOperator.charAt(i); //converts string to char
				operator.push(c); //pushes input to stack
		}
			if(c == 'C' || c == 'c'){	//clears stack
				operator.clear();
				pointOperator = "";
			}
			
			if(c == 'Q' || c == 'q'){	//terminated program
				System.exit(0);
			}
			
			if(c == '='){	//evaluates expression
				while(operator.isEmpty() == false){
					
					String post = convertToPostfix(pointOperator);
					System.out.print("Postfix Expression: " + post + "\n");
					int answer = operator.evaluatePostfix(post);
					System.out.print("The answer is: " + answer + "\n");
					operator.clear();
					pointOperator = "";
				}
			}
			
			if(c == '<'){	//deletes last input
				if(operator.isEmpty() == false){
					pointOperator = pointOperator.substring(0, pointOperator.length() - 2);
					operator.pop();
					operator.pop();
				}
				
			}	
			System.out.print("The string is: " + pointOperator + "\n"); //outputs string
		}
		
	}
}