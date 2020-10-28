import java.util.*;
import java.math.BigInteger;

public class dh_two {
	// [F] getNextPrime //
	public static BigInteger randomPrime(String NumOfBits) {
		// [INIT] //
		boolean everythingIsGood = true;
		List<BigInteger> allPrimesInRange = new ArrayList<BigInteger>();


		// [CALL] Return string of binary range // [OUTPUT] //
		String[] range = createRangeBinaryStrings(NumOfBits);
		System.out.println("Range:")
		System.out.println("Range: [" + range[0] + " - " + range[1] + "]");
		

		// [CONVERSION] Binary String to BigInteger Values //
		BigInteger bigInt_rangeMin = new BigInteger(range[0], 2);
		BigInteger bigInt_rangeMax = new BigInteger(range[1], 2);
		

		// [OUTPUT] Integar Value //
		System.out.println("Range (Decimal Values):")
		System.out.println("[" + bigInt_rangeMin + ", " +bigInt_rangeMax + "]\n");


		// Create New variables exclusively to be used in the while loop
		BigInteger while_bigInt_rangeMin = bigInt_rangeMin;
		BigInteger while_bigInt_rangeMax = bigInt_rangeMax;


		// [LOOP] Go through all numbers within the range // 
		while (everythingIsGood == true) {
			// [INIT] //
			BigInteger increment = new BigInteger("1");

			// [INCREMENT] //
			while_bigInt_rangeMin = while_bigInt_rangeMin.add(increment);

			// [COMPARE] // [RESPOND] //	
			int comparevalue = while_bigInt_rangeMin.compareTo(while_bigInt_rangeMax);
			
			if (comparevalue == 1) { break; }

			// [T/F] Check if current number is prime //
			boolean result = while_bigInt_rangeMin.isProbablePrime(1);

			// [RECORD] If is prime is true add to the list //
			if (result == true) {
				System.out.println("Prime Found: " + while_bigInt_rangeMin);
				allPrimesInRange.add(while_bigInt_rangeMin);
			}
		}
		System.out.println("\n");

		// [OUTPUT] allPrimesInRange //
		//for (BigInteger listItem : allPrimesInRange) { System.out.println(listItem); }


		// Choose Random Prime to return //
		Random rand = new Random();
		BigInteger returned_p = allPrimesInRange.get(rand.nextInt(allPrimesInRange.size()));

		// [RETURN] Big Integer //
		return returned_p;
	}
	
	
	
	// [F] createRangeBinaryStrings //
	public static String[] createRangeBinaryStrings(String NumOfBits) {
		// [INIT] //
		String rangeMin = "1";
		String rangeMax = "1";
		int int_numOfBits;

		// [CONVERSION] String to int //
		int_numOfBits = Integer.parseInt(NumOfBits);

		// Create Range String //
		for (int i = 0; i < (int_numOfBits - 1); i++) {
			rangeMin = rangeMin.concat("0");
			rangeMax = rangeMax.concat("1");
		}

		// Store into string array to be returned //
		String[] range = { rangeMin, rangeMax };

		// [RETURN] String Array //
		return range;
	}
	
	
	// [F] generateGenerator //
	public static BigInteger generateGenerator(int generatorLimit) {
		int int_g;
		Random ran = new Random();
		BigInteger generator;

		// Random Numbers Generation // Convert Int to BigInt //
		int_g = ran.nextInt((generatorLimit - 2) + 1) + 2;
		generator = BigInteger.valueOf(int_g);

		// [RETURN] Big Integer //
		return generator;
	}

	public static void main(String args[]) {
		// [INIT] //
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String numOfBits;
		int int_a, int_b;
		BigInteger p, g, a, b, A, B, messageA, messageB;

		// [INPUT] Get Number of bits from the user // Take Value // Close //
		System.out.println("Enter the size of p (in bits):");
		numOfBits = scanner.next();
		scanner.close();
	

		/*** p & g **************************************************/
		// [CALL] Get Next Prime //
		p = randomPrime(numOfBits);
		
		// [CONVERT] int to bigInteger //
		g = generateGenerator(100);

		/*** ALICE pt. 1 ********************************************/
		// [INIT] Generating value of a //
		int_a = random.nextInt(99);

		// [CONVERT] int to bigInteger //
		a = BigInteger.valueOf(int_a);
		
		// [ARITHMETIC] A = g^a mod p //
		A = g.pow(int_a);
		A = A.mod(p);
		
		/*** BOB pt. 1 **********************************************/
		// [INIT] Generating value of b //
		int_b = random.nextInt(99);

		// [CONVERT] Convert int to bigInteger //
		b = BigInteger.valueOf(int_b);

		// [ARITHMETIC] B = g^b mod p //
		B = g.pow(int_b);
		B = B.mod(p);
		

		/*** ALICE pt. 2 ********************************************/
		// [ARITHMETIC] M = B^a mod p //
		messageA = B.pow(int_a);
		messageA = messageA.mod(p);

		/*** BOB pt. 2 **********************************************/
		// [ARITHMETIC] M = A^b mod p //
		messageB = A.pow(int_b);
		messageB = messageB.mod(p);


		// [OUTPUT] - Display all the variables //
		System.out.println("Public p Value: " + p);
		System.out.println("Public g Value: " + g);
		System.out.println("Private a Value: " + a);
		System.out.println("Private b Value: " + b);
		System.out.println("Alice sends A --> Bob: " + A);
		System.out.println("Bob sends B --> Alice: " + B);
		System.out.println("The Key A calculated value: " + messageA);
		System.out.println("The Key B calculated Value: " + messageB);	
		System.out.println("----------------------------------------------------------------");
	}
}