import java.util.*;
import java.math.BigInteger;

public class test {
	final static BigInteger one = new BigInteger("1");

	public static void main(String args[]) {
		// [INIT] //
		BigInteger test = new BigInteger(
			"89884656743115795386465259539451236680898848947115328636715040578866337902750481566354238661203768010560056939935696678829394884407208311246423715319737062188883946712432742638151109800623047059726541476042502884419075341171231440736956555270413618581675255342293149119973622969239858152417678164812112068608"
		);


		// [EXAMPLE] Array //
		BigInteger[] arr = { test, test };
		System.out.println("ARRAY");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println("\n");


		// [EXAMPLE] List //
		List<BigInteger> list = new ArrayList<BigInteger>();
		list.add(test);
		list.add(test);

		// Print the name from the list....
		for (BigInteger listItem : list) { System.out.println(listItem); }



		// [EXAMPLE] Copy 1 Big Int to Another //
		BigInteger test1 = new BigInteger("5");
		BigInteger test2 = test1;

		System.out.println("test1: " + test1);
		System.out.println("test2: " + test2);



		/*** ADDING ***/
		BigInteger sum;  

		// Convert the string input to BigInteger 
		BigInteger a = new BigInteger("1"); 
		BigInteger b = new BigInteger("5"); 

		// Using add() method 
		sum = a.add(a); 

		// Display the result in BigInteger 
		System.out.println(
			"The sum of\n" + a + " \nand\n" + b + " " + "\nis\n" + sum + "\n"
		); 



		/*** WHILE LOOP ***/
		boolean wegood = true;
		BigInteger while_bigInt_rangeMin = new BigInteger("70");
		BigInteger while_bigInt_rangeMax = new BigInteger("100");
		List<BigInteger> apir = new ArrayList<BigInteger>();
		BigInteger increment = new BigInteger("1");

		while (wegood == true) {
			// [INCREMENT] //
			while_bigInt_rangeMin = while_bigInt_rangeMin.add(increment);

			// [COMPARE] // [RESPOND] //	
			int comparevalue = while_bigInt_rangeMin.compareTo(while_bigInt_rangeMax);
			
			if (comparevalue == 1) { break; }
			
			// Action goes here..
			apir.add(while_bigInt_rangeMin);
		}

		// Print the name from the list....
		for (BigInteger listItem : apir) { System.out.println(listItem); }


		// CHECK IF NUMBER IS PRIME //
		BigInteger pp = new BigInteger("104729");

		boolean result = pp.isProbablePrime(80);

		System.out.println(a.toString() + " with certainty 1 " + result); 
	}
}