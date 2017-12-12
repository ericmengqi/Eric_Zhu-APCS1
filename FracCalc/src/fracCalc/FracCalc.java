/*
 * @author Eric Zhu
 * 
 * @date 11/27/17
 * 
 * @purpose Create a calculator that will correctly add, subtract, multiply, 
 * and divide fractions. Correctly reduce the answer in simplest form (reduced
 * form or mixed number in reduced form if the numerator of the answer is 
 * greater than the denominator). 
 * 
 */
package fracCalc;

import java.util.*;

public class FracCalc {
	public static void main(String[] args) {
		String userInput = "";
		Scanner scanInput = new Scanner(System.in);
		while (userInput != "quit") {
			userInput = scanInput.nextLine();
			System.out.println(produceAnswer(userInput));
		}
	}

	public static String produceAnswer(String input) {
		String[] stringSplit = input.split(" ");
		return input;
		
	}
}
