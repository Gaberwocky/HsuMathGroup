package application.main;
	
import java.util.Arrays;
import java.util.Collections;


/**
 *
 */
public class MexValueFinder {
	public static int getNIM(int n, int k) throws IllegalArgumentException{
		if(n < 0 || k < 0){
			throw new IllegalArgumentException("Both numbers should be non-negative");
		}
		// otherwise, continue
		String nString = Integer.toBinaryString(n);
		String kString = Integer.toBinaryString(k);
		String longest = ""; String shortest = "";
		int nStringlen = nString.length();
		int kStringlen = kString.length();
		if(nStringlen > kStringlen){
			longest = nString;
			shortest = kString;
		}
		else { longest = kString; shortest = nString;}

		// calcuating the differece between strings
		int difference = longest.length() - shortest.length();
		String result = "";
		// iterate from right to left
		for(int i = longest.length() - 1; i >= 0; i--){
			int tempNum = 0;
			if(longest.length() - i <= shortest.length()){
				tempNum += Character.getNumericValue(shortest.charAt(i - difference));
			}
			tempNum += Character.getNumericValue(longest.charAt(i));
			int mod = tempNum % 2;
			result = Integer.toString(mod) + result;
		}
		int solution = Integer.parseInt(result,2);
		return solution;
	}




	public static void main(String[]args) {
	
	// Will be built of ints
	int[] nimValArr = {12, 2, 14, 0 , 1 , 3, 3, 2, 3};
	 // should have tests for having all values, 
	//repeated values, empty array, return error

	
	// will tell us how many iterations 
	int nimValueLength = nimValArr.length;
	
	int mex = -1;	

	
	//-1 will act as a flag if something is wrong
	
	//Will give us the highest number to check
	int nimMax = nimValArr[0]; 
	for ( int i = 1; i < nimValueLength ; i++ )
	{	if (nimValArr[i] > nimMax)
		{ 	nimMax = nimValArr[i]; }	
	}
	

	boolean[] boolSieve = new boolean[++nimMax];
	
	//changing bool to true if that number is in the array
	for ( int i =0; i < nimValueLength; i++ )
	{
		int temp = nimValArr[i];
		boolSieve [temp] = true;
		System.out.println("temp: " + temp + "boolSieve [temp]: " +boolSieve [temp]);
	}
	
	// check for first false in boolSieve
	for ( int i =0; i<++nimMax; i++ )
	{	
		if (boolSieve[i] == false)
		{	mex = i;
			break;
		}
		System.out.println("index: " + i + "   bool value: " + boolSieve[i] );
	}
	
	System.out.println("MEX value is: " + mex);
	
	}
	
}			