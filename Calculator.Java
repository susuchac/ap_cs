import java.util.Scanner;

public class Calculator {
	public static void main(String [] args) {
		int number1 = 0;
		int numerator1 = 0;
		int denominator1 = 1;
		int number2 = 0;
		int numerator2 = 0;
		int denominator2 = 1;
		Scanner console = new Scanner(System.in);
		while(true) {
			System.out.print("Please enter a mathematical expression: ");
			String firstInput = console.next();
			if(firstInput.equals("quit")) {
				System.out.println("goodbye");
				break;
			}
			String operator = console.next();
			String secondInput = console.next();
			int firstIndex1 = firstInput.indexOf("_");
			int firstIndex2 = firstInput.indexOf("/");
			int secondIndex1 = secondInput.indexOf("_");
			int secondIndex2 = secondInput.indexOf("/");
			String num1 = "";
			String num2 = "";
			if(firstIndex1 != -1 && firstIndex2 != -1) { //mixed number: number, numerator, denominator
				number1 = getNumber(firstInput, 0, firstIndex1);
				numerator1 = getNumber(firstInput, firstIndex1+1, firstIndex2);
				denominator1 = getNumber(firstInput, firstIndex2+1, firstInput.length());
				if(number1 > 0) 
					numerator1 = number1 * denominator1 + numerator1;
				else
					numerator1 = number1 * denominator1 - numerator1;
				num1 = simplify(numerator1, denominator1);
			} else if(firstIndex1 == -1 && firstIndex2 != -1) { //fraction: numerator, denominator
				numerator1 = getNumber(firstInput, firstIndex1+1, firstIndex2);
				denominator1 = getNumber(firstInput, firstIndex2+1, firstInput.length());
				num1 = simplify(numerator1, denominator1);
			} else if(firstIndex1 == -1 && firstIndex2 == -1) { 
				number1 = getNumber(firstInput, 0, firstInput.length());
				num1 = number1 + "";
				numerator1 = number1 * denominator1;
			}
			if(secondIndex1 != -1 && secondIndex2 != -1) {
				number2 = getNumber(secondInput, 0, secondIndex1);
				numerator2 = getNumber(secondInput, secondIndex1+1, secondIndex2);
				denominator2 = getNumber(secondInput, secondIndex2+1, secondInput.length());
				if(number2 > 0) 
					numerator2 += number2 * denominator2;
				else
					numerator2 = number2 * denominator2 - numerator2;
				num2 = simplify(numerator2, denominator2);
			} else if(secondIndex1 == -1 && secondIndex2 != -1) {
				numerator2 = getNumber(secondInput, secondIndex1+1, secondIndex2);
				denominator2 = getNumber(secondInput, secondIndex2+1, secondInput.length());
				num2 = simplify(numerator2, denominator2);
			} else if(secondIndex1 == -1 && secondIndex2 == -1) {
				number2 = getNumber(secondInput, 0, secondInput.length());
				num2 = number2 + "";
				numerator2 = number2 * denominator2;
			}
			String str = "";
			if(operator.equals("+")) {
				str = addition(numerator1, numerator2, denominator1, denominator2);
			} else if(operator.equals("-")) {
				str = subtraction(numerator1, numerator2, denominator1, denominator2);
			} else if(operator.equals("*")) {
				str = multiplication(numerator1, numerator2, denominator1, denominator2);
			} else if(operator.equals("/")) {
				str = division(numerator1, denominator2, numerator2, denominator1);
			}
			System.out.println(str);
			System.out.println();
		}
	}
	public static int getNumber(String input, int index1, int index2) {
		String number = input.substring(index1, index2);
		int num = Integer.parseInt(number);
		return num;
	}
	public static String addition(int numerator1, int numerator2, int denominator1, int denominator2) {
		int numerator = (numerator1*denominator2) + (numerator2*denominator1);
		int denominator = (denominator1*denominator2);
		return simplify(numerator, denominator);
	}
	public static String subtraction(int numerator1, int numerator2, int denominator1, int denominator2) {
		int numerator = (numerator1*denominator2) - (numerator2*denominator1);
		int denominator = (denominator1*denominator2);
		return simplify(numerator, denominator);
	}
	public static String multiplication(int numerator1, int numerator2, int denominator1, int denominator2) {
		int numerator = numerator1*numerator2;
		int denominator = denominator1*denominator2;
		return simplify(numerator, denominator);
	}
	public static String division(int numerator1, int numerator2, int denominator1, int denominator2) {
		return multiplication(numerator1, denominator2, numerator2, denominator1);
		//uses multiplication method b/c division of fractions is reciprocal multiplication
	}
	public static String simplify(int numerator, int denominator) {
		String str = "";
		int num = 0;
		if((numerator > denominator) || (numerator*-1 > denominator)) {
			num = numerator/denominator;  //for numerator > denominator, separates improper fraction into fraction and whole number
			numerator = numerator%denominator;
		}
		int check = 1; //check = common factor
		for(int i = 1; i <= numerator || i <= numerator*-1 ; i++) {
			if(numerator%i==0 && denominator%i==0) { //checks if numerator/denominator divisible by i
				check = i; //if true, change check value to i
			}
		}
		numerator = numerator/check; //divide numerator and denominator by common factor
		denominator = denominator/check;
		if(numerator==0 && num != 0) {
			str = num + ""; //cannot print numerator because currently equal to 0
		} else if(numerator!=0 && num==0 && denominator==1) {
			str = numerator + ""; //cannot print num because currently equal to 0. denominator = 1, so also don't print denominator
		} else if(num == 0) {
			if(numerator == 0) {
				str = "0";
			} else {
				str = numerator + "/" + denominator;
			}
		} else if(numerator < 0) {
			str = num + "_" + numerator * -1 + "/"+ denominator;
		} else {
			str = num + "_" + numerator + "/" + denominator;
		}
		return str;
	}
}