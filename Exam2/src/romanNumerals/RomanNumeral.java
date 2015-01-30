package romanNumerals;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This class converts integers to Roman numerals
 * 
 * @author millerc5. Created Oct 25, 2013.
 */
public class RomanNumeral {

	/**
	 * This map holds all the special cases for converting integers to Roman
	 * numerals. The key in a key-value pair is the integer to convert to Roman
	 * numerals and the value is the Roman numeral equivalent.
	 */

	private HashMap<Integer, String> romanNumbers;

	/**
	 * This array contains all the keys from the romanNumbers map sorted in
	 * increasing order.
	 */
	private Integer[] specialValues;

	/**
	 * Initializes the romanNumbers map and the specialValues array.
	 * 
	 */
	public RomanNumeral() {
		createMap();
		this.specialValues = new Integer[this.romanNumbers.keySet().size()];
		int i = 0;
		for (Integer integer : this.romanNumbers.keySet()) {
			this.specialValues[i] = integer;
			i++;
		}
		Arrays.sort(this.specialValues);
	}

	/**
	 * Converts positive integer n to Roman numerals.
	 * 
	 * @param n
	 *            The integer to convert to Roman numerals. n must be in the
	 *            range 1 to 3999.
	 * @return The Roman numeral equivalent of n.
	 */
	public String intToRomanNumeral(int n) {
		return intToRomanNumeralRecursive(n, 0);
	}

	/**
	 * Uses the HashMap this.romanNumbers and the array this.specialValues to
	 * recursively compute and return the Roman numeral equivalent of the
	 * parameter n.
	 * 
	 * @param n
	 *            The integer to convert to Roman numerals.
	 * @param location
	 *            The index of the array this.specialValues that contains a key
	 *            in the map this.romanNumbers to consider.
	 * @return The Roman numeral equivalent of n.
	 */
	private String intToRomanNumeralRecursive(int n, int location) {
		if(n==0) return "";
		
		String toAdd = "";
		int number = n%10;
		if(number<4){
			for(int i = 0; i < number; i++){
				toAdd+=this.romanNumbers.get(this.specialValues[location]);
			}
		}else if(number == 4){
			toAdd = this.romanNumbers.get(this.specialValues[location+1]);
		}else if(number == 9){
			toAdd = this.romanNumbers.get(this.specialValues[location+3]);
		}else if(number > 4){
			toAdd+= this.romanNumbers.get(this.specialValues[location+2]);
			for(int i = 5; i < number; i++){
				toAdd+=this.romanNumbers.get(this.specialValues[location]);
			}
		}
		
		return intToRomanNumeralRecursive(n/10,location+4) + toAdd;
	}

	/**
	 * 
	 * Creates and initializes a map that holds all the special cases for
	 * converting integers to Roman numerals.
	 * 
	 */
	private void createMap() {
		this.romanNumbers = new HashMap<Integer, String>();
		this.romanNumbers.put(1000, "M");
		this.romanNumbers.put(900, "CM");
		this.romanNumbers.put(500, "D");
		this.romanNumbers.put(400, "CD");
		this.romanNumbers.put(100, "C");
		this.romanNumbers.put(90, "XC");
		this.romanNumbers.put(50, "L");
		this.romanNumbers.put(40, "XL");
		this.romanNumbers.put(10, "X");
		this.romanNumbers.put(9, "IX");
		this.romanNumbers.put(5, "V");
		this.romanNumbers.put(4, "IV");
		this.romanNumbers.put(1, "I");
	}

}
