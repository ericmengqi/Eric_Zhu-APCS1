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

public class FracCalcOld {

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
		String operand1 = stringSplit[0];
		String operator = stringSplit[1];
		String operand2 = stringSplit[2];
		int[] firstOperand = new int[3];
		int[] secondOperand = new int[3];
		// Creates new Arrays for each Operand.
		// Does this so does not have to make an int represent a type of the operator
		// during parseOperand.
		firstOperand = parseOperand(operand1);
		if (firstOperand[2] == 0) {
			return ("ERROR: Cannot divide by zero.");
		}
		secondOperand = parseOperand(operand2);
		if (secondOperand[2] == 0) {
			return ("ERROR: Cannot divide by zero.");
		}
		// Cannot divide by 0.
		// Return error message if denom is 0.
		int[] improperOperand1 = toImproperFrac(firstOperand[0], firstOperand[1], firstOperand[2]);
		int[] improperOperand2 = toImproperFrac(secondOperand[0], secondOperand[1], secondOperand[2]);
		int[] answer = new int[2];
		if (operator.equals("*")) {
			answer = multDiv(improperOperand1[0], improperOperand1[1], improperOperand2[0], improperOperand2[1]);
		} else if (operator.equals("+")) {
			answer = addSub(improperOperand1[0], improperOperand1[1], improperOperand2[0], improperOperand2[1]);
		} else if (operator.equals("/")) {
			answer = multDiv(improperOperand1[0], improperOperand1[1], improperOperand2[1], improperOperand2[2]);
		} else if (operator.equals("-")) {
			answer = addSub(improperOperand1[0], improperOperand1[1], -1 * improperOperand2[0], improperOperand2[1]);
		}
		return answer.toString();
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

	public static int[] toImproperFrac(int wholeNum, int numerator, int denominator) {
		// Take the parsed operand and change it into an improper fraction.
		if (wholeNum < 0) {
			// If the whole number is negative, the numerator must be negative.
			// Subtract numerator instead of add numerator.
			numerator = (wholeNum * denominator) - numerator;
		} else {
			numerator = (wholeNum * denominator) + numerator;
		}
		int[] improperFrac = new int[2];
		improperFrac[0] = numerator;
		improperFrac[1] = denominator;
		return improperFrac;
	}

	public static int[] toMixedNum(int numerator, int denominator) {
		// Used this to simplify the fraction to its simplest form.
		// Changes the improper frac into a mixed num.
		int wholeNum = numerator / denominator;
		int newNumer = numerator % denominator;
		int[] mixedNum = new int[3];
		if (numerator % denominator != 0) {
			mixedNum[0] = wholeNum;
			mixedNum[1] = newNumer;
			mixedNum[2] = denominator;
		} else {
			mixedNum[0] = wholeNum;
		}
		return mixedNum;
	}

	public static int gcf(int numerator, int denominator) {
		// When trying to find the simplest form, divide both numbers by the gcf.
		// Uses this to find the gcf of the two number.
		if (numerator == 0) {
			return denominator;
		}
		if (denominator == 0) {
			return numerator;
		}
		if (numerator % denominator == 0) {
			return denominator;
		} else {
			return gcf(denominator, numerator % denominator);
		}
	}

	public static int[] multDiv(int numer1, int denom1, int numer2, int denom2) {
		// Multiply two improper fraction together.
		int newNumer = numer1 * numer2;
		int newDenom = denom1 * denom2;
		int[] newFraction = { newNumer, newDenom };
		return newFraction;
	}

	public static int[] addSub(int numer1, int denom1, int numer2, int denom2) {
		// Adds two improper frac together.
		int newNumer;
		int newDenom;
		if (denom1 != denom2) {
			// To add fractions, you need to have the same denominator.
			// Changes the fraction so both will have the same denominator.
			newDenom = denom1 * denom2;
			newNumer = (numer1 * denom2) + (numer2 * denom1);
		} else {
			newDenom = denom1;
			newNumer = numer1 + numer2;
		}
		int[] newFraction = { newNumer, newDenom };
		return newFraction;
	}

	public static int[] parseOperand(String operand) {
		// Parses each operand into three different numbers.
		// A wholeNum, numerator, and denominator in that order in an array of ints.
		String[] splitFraction = operand.split("_");
		String wholeNum;
		String numerator;
		String denominator;
		if (splitFraction.length == 2) {
			wholeNum = splitFraction[0];
			String[] splitFractionAgain = splitFraction[1].split("/");
			if (splitFractionAgain.length == 1) {
				numerator = splitFractionAgain[0];
				denominator = "1";
			} else {
				numerator = splitFractionAgain[0];
				denominator = splitFractionAgain[1];
			}
		} else {
			wholeNum = "0";
			String[] splitFractionAgain = splitFraction[0].split("/");
			if (splitFractionAgain.length == 1) {
				numerator = splitFractionAgain[0];
				denominator = "1";
			} else {
				numerator = splitFractionAgain[0];
				denominator = splitFractionAgain[1];
			}
		}
		int[] fractionArray = new int[3];
		fractionArray[0] = Integer.parseInt(wholeNum);
		fractionArray[1] = Integer.parseInt(numerator);
		fractionArray[2] = Integer.parseInt(denominator);
		// Changes the string to an int.
		return fractionArray;
	}
}
