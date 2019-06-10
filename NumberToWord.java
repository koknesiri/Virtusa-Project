package CodeTest.NumbertoWord;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class NumberToWord {


	public static final String[] units = { "", "One", "Two", "Three", "Four",
		"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
		"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
		"Eighteen", "Nineteen" };

	public static final String[] tens = { 
		"", 		// 0
		"",		// 1
		"Twenty", 	// 2
		"Thirty", 	// 3
		"Forty", 	// 4
		"Fifty", 	// 5
		"Sixty", 	// 6
		"Seventy",	// 7
		"Eighty", 	// 8
		"Ninety" 	// 9
	};

	public static String convert(final int num) { // converting number to words
		if (num < 0) {
			return "Minus " + convert(-num);
		}

		if (num < 20) {
			return units[num];
		}

		if (num < 100) {
			return tens[num / 10] + ((num % 10 != 0) ? " " : "") + units[num % 10];
		}

		if (num < 1000) {
			return units[num / 100] + " Hundred " + ((num % 100 != 0) ? " " : "") +convert(num % 100); // recursive call for converting big numbers
		}

		if (num < 100000) {
			return convert(num / 1000) + " Thousand " + ((num % 10000 != 0) ? " " : "") + convert(num % 1000);
		}

		if (num < 10000000) {
			return convert(num / 100000) + " Lakh  " + ((num % 100000 != 0) ? " " : "") + convert(num % 100000);
		}

		return convert(num / 10000000) + " Crore " + ((num % 10000000 != 0) ? " " : "") + convert(num % 10000000);
	}
	public static String getStackTraceAsString(Throwable e,int startIndex, int length){
		String exception = "";
		try(StringWriter sw = new StringWriter()){
			e.printStackTrace(new PrintWriter(sw));
			exception = sw.toString();
			if(exception != null && length > 0 && exception.length() > length){
				exception = exception.substring(startIndex ,length-1);
			}
		}catch(Exception ee){

		}
		return exception;
	}
	public static void main(final String[] args) {
		Scanner scan=null;

		try{
			int n;
			scan=new Scanner(System.in);
			System.out.println("Enter a number to convert into word format");
			n =scan.nextInt();
			System.out.println(NumberFormat.getInstance().format(n) + "='" + convert(n) + "'");
		}catch(Throwable e){
			System.out.println(getStackTraceAsString(e,10,35));
			//e.printStackTrace();
		}
		finally{
			scan.close();
		}


	}
}
