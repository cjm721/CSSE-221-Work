import java.io.IOException;
import java.util.List;

/**
 * TODO: <<Your snazzy documentation here>>.
 * 
 * @author <<You>>. Created <<date>>.
 */
public class Markov {

	private static final String DEFAULT_FILE = "Oz.txt";
	private static final int DEFAULT_N = 3;
	private static final int DEFAULT_MAX = 100;
	private static final int DEFAULT_CPL = 72;

	/**
	 * Command-line entry point for program.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Chain ch = null;
		if (args.length > 0) {
		ch = new Chain(args[0], Integer.parseInt(args[1]), Integer
				.parseInt(args[2]), Integer.parseInt(args[3]));
		} else {
			ch = new Chain(DEFAULT_FILE, DEFAULT_N, DEFAULT_MAX, DEFAULT_CPL);
		}
		System.out.println("-----MILESTONE 1 should print one long list of words.-----");
		List<String> words = ch.getWords();
		for (String w : words) {
			System.out.print(w + " ");
		}
		System.out.println("\n"); 
		
		System.out.println("-----MILESTONE 2 should print the list as a paragraph with justification (extra credit).-----");
		List<String> lines = ch.getWrappedLines();
		for (String l : lines) {
			System.out.println(l);
		}
	}
}
