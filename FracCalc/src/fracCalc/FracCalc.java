package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	String userInput = "";
    	Scanner scan = new Scanner(System.in);
    	//System.out.println("Please input your equation: ");
    	while (userInput != "quit" ) {
    	String fracInput = scan.nextLine();
    	System.out.println(produceAnswer(fracInput));
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] stringSplit = input.split(" ");
        String operand1 = stringSplit[0];
        String operator = stringSplit[1];
        String operand2 = stringSplit[2];
        String[] splitOperand1 = operand1.split("_");   
        return ("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
    }
    public static String splitOperand (String input) {
    	 String[] stringSplit = input.split(" ");
         String whole;
         String numerator;
         String denominator;
         String operand;
		String[] splitOperand = operand.split("_");
         if(splitOperand.length == 2){
         	whole = splitOperand[0];
             String[] splitOperandAgain = splitOperand[0].split("/");
         	if(splitOperandAgain.length == 1){
         		numerator = splitOperandAgain[0];
         		denominator = "1";
         	} else{
         		numerator = splitOperandAgain[0];
         		denominator = splitOperandAgain[1];
         	}
         } else{
             String[] splitOperandAgain = splitOperand[0].split("/");
             whole = "0";
         	if(splitOperandAgain.length == 1){
         		numerator = splitOperandAgain[0];
         		denominator = "1";
         	} else{
         		numerator = splitOperandAgain[0];
         		denominator = splitOperandAgain[1];
         	}
         }
         return ("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
     }
}

    // TODO: Fill in the space below with any helper methods that you think you will need
    
