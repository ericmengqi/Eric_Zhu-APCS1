package fracCalc;

import org.junit.Test;

// Checkpoint 2-only tests
public class FracCalcTestCheckpoint2
{
    @Test public void testCheckpoint2_1() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:6 numerator:5 denominator:8", "12_3/8", FracCalc.produceAnswer("5_3/4 + 6_5/8"));}
    @Test public void testCheckpoint2_2() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:20 numerator:0 denominator:1", "-20_3/7", FracCalc.produceAnswer("-3/7 - 20"));}
    @Test public void testCheckpoint2_3() {  FracCalcTestALL.assertForEarlyCheckpoints(null, "whole:0 numerator:27 denominator:21", "-33_2/7", FracCalc.produceAnswer("-32 - 27/21"));}

    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] stringSplit = input.split(" ");
        String operand1 = stringSplit[0];
        String operator = stringSplit[1];
        String operand2 = stringSplit[2];
        String wholeNum;
        String numerator;
        String denominator;
        String wholeNum1;
        String numerator1;
        String denominator1;
        String[] splitOperand1 = operand1.split("_");
        if(splitOperand1.length == 2){
        	wholeNum = splitOperand1[0];
            String[] splitOperand1Again = splitOperand1[0].split("/");
        	if(splitOperand1Again.length == 1){
        		numerator = splitOperand1A[0];
        		denominator = "1";
        	} else{
        		numerator = splitOperand1Again[0];
        		denominator = splitOperand1Again[1];
        	}
        } else{
            String[] splitOperand1Again = splitOperand1[0].split("/");
            wholeNum = "0";
        	if(splitOperand1Again.length == 1){
        		numerator = splitOperand1Again[0];
        		denominator = "1";
        	} else{
        		numerator = splitOperand1Again[0];
        		denominator = splitOperand1Again[1];
        	}
        }
        String[] splitOperand2 = operand2.split("_");
        if(splitOperand2.length == 2){
        	wholeNum1 = splitOperand2[0];
            String[] splitOperand2Again = splitOperand2[1].split("/");
        	if(splitOperand2Again.length == 1){
        		numerator1 = splitOperand2Again[0];
        		denominator1 = "1";
        	} else{
        		numerator1 = splitOperand2Again[0];
        		denominator1 = splitOperand2Again[1];
        	}
        } else{
            String[] splitOperand2Again = splitOperand2[0].split("/");
        	if(splitOperand2Again.length == 1){
        		wholeNum1 = splitOperand2[0];
        		numerator1 = "0";
        		denominator1 = "1";
        	} else{
        		wholeNum1 = "0";
        		numerator1 = splitOperand2Again[0];
        		denominator1 = splitOperand2Again[1];
        	}
        }
        return ("whole:" + wholeNum1 + " numerator:" + numerator1 + " denominator:" + denominator1);
    }

}
