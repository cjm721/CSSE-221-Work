
/**
 * This class contains a method used to translate English to PigLatin. 
 * I use it simply to demonstrate the process of unit testing.
 *
 * @author Matt Boutell.
 *         Created Sep 1, 2006.
 */
public class PigLatiner {

	/**
	 * This method finds the pig latin anslationtray of a word.
	 *
	 * @param s
	 * @return The pig latin anslationtray of a word.
	 */
	public static String transform(String s) {
		if(s == null) return null;
		s = s.toLowerCase();
		int i = 0;
		
		for(;i < s.length(); i++){
			if(isVowel(s.charAt(i))) break;
		}

		if (i == 0) {
			return s + "way";
		}
		return s.substring(i) + s.substring(0,i) + "ay";
	}

	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o');
	}
}
