/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calc {
    String[] splits = null;
    BigDecimal[] operators = new BigDecimal[2];
	public String doCalc(String cmd){
		cmd=cmd.replaceAll("\\s","");
	    splits = cmd.split("\\+");
        try{
	        operators[0] = new BigDecimal(splits[0]);
	        operators[1] = new BigDecimal(splits[1]);
	        return (operators[0].add(operators[1])).toString();
        }
        catch(NumberFormatException e){
	            return multiply(cmd);
	        }
	}
	private String multiply(String cmd) {
	    splits = cmd.split("\\*");
	    try{
		    operators[0] = new BigDecimal(splits[0]);
		    operators[1] = new BigDecimal(splits[1]);
		    return (operators[0].multiply(operators[1])).toString();
	    }catch(NumberFormatException e){
	        return subtract(cmd);
	    }
	}

	private String subtract(String cmd) {
	    splits = cmd.split("\\-");
	    try{
		    operators[0] = new BigDecimal(splits[0]);
		    operators[1] = new BigDecimal(splits[1]);
		    return (operators[0].subtract(operators[1])).toString();
	    }catch(NumberFormatException e){
	        return divide(cmd);
	    }
	}

	private String divide(String cmd) {
	    splits = cmd.split("\\/");
	    try{
	    	operators[0] = new BigDecimal(splits[0]);
	    	operators[1] = new BigDecimal(splits[1]);
		    try{
		    	return (operators[0].divide(operators[1])).toString();
		    }catch(java.lang.ArithmeticException a){
		    	return (operators[0].divide(operators[1], 7, RoundingMode.HALF_UP)).toString();
		    }
	    }catch(NumberFormatException e){
	        return "Invalid command to calc";
	    }
	}
}
