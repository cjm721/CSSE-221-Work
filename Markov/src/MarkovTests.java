
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This class holds data for driving the test cases for the Markov project.
 * 
 * @author Curt Clifton Created Dec 3, 2007.
 */
public abstract class MarkovTests extends TestCase {
	/**
	 * This inner class stores a single set of parameters for invoking the
	 * Markov chain algorithm.
	 */
	static class Parameters {

		/**
		 * The name of the file to read.
		 */
		final String fileName;

		/**
		 * The prefix length for the test case.
		 */
		final int prefixLength;

		/**
		 * The maximum number of words to output for the test case.
		 */
		final int maxWords;

		/**
		 * The width of the justified text for the test case.
		 */
		final int justificationWidth;

		/**
		 * Whether or not the test case should verify random results.
		 */
		final boolean testRandomization;

		/**
		 * Constructs a parameter set that includes randomization verification.
		 * 
		 * @param fileName
		 * @param prefixLength
		 * @param maxWords
		 * @param justificationWidth
		 */
		public Parameters(String fileName, int prefixLength, int maxWords,
				int justificationWidth) {
			this(fileName, prefixLength, maxWords, justificationWidth, true);
		}

		/**
		 * Constructs a parameter set.
		 * 
		 * @param fileName
		 * @param prefixLength
		 * @param maxWords
		 * @param justificationWidth
		 * @param testRandomization
		 */
		public Parameters(String fileName, int prefixLength, int maxWords,
				int justificationWidth, boolean testRandomization) {
			this.fileName = fileName;
			this.prefixLength = prefixLength;
			this.maxWords = maxWords;
			this.justificationWidth = justificationWidth;
			this.testRandomization = testRandomization;
		}

	}

	/**
	 * A list of the names of the files to use for testing.
	 */
	protected static final Parameters[] TEST_PARAMETERS = {
		new Parameters("simple.txt", 1, 100, 25),
		new Parameters("simple.txt", 3, 40, 35),
		new Parameters("simple.txt", 5, 50, 30, false),
		new Parameters("simple.txt", 6, 100, 25, false),
		new Parameters("simple.txt", 25, 100, 25, false),
		new Parameters("noChoices.txt", 1, 50, 40, false),
		new Parameters("wrap-test.txt", 2, 50, 39, false),
		new Parameters("wrap-test.txt", 2, 50, 39, false),
		new Parameters("Markov-testfile-1.txt", 2, 100, 40),
		new Parameters("tales-from-shakespeare.txt", 2, 100, 40, false),
		new Parameters("Oz-1.txt", 2, 200, 72, false),
		new Parameters("Oz-3.txt", 2, 200, 72, false),
		new Parameters("Oz-5.txt", 2, 200, 72, false),
		new Parameters("Oz-7.txt", 2, 200, 72, false),
		new Parameters("Oz-shorter.txt", 2, 200, 72, false),
		new Parameters("Oz.txt", 2, 200, 72, false),
		new Parameters("last-of-the-mohicans.txt", 2, 200, 72, false) };

	/**
	 * Tracks whether any failures have occured for the current test case. 
	 */
	protected static boolean testTypeFailed = false;
	
	/**
	 * @param p
	 * @return a Markov chain object based on the given parameters
	 * @throws IOException
	 */
	protected static Chain chainFromParms(Parameters p) {
		return new Chain(p.fileName, p.prefixLength, p.maxWords,
				p.justificationWidth);
	}
	
	/**
	 * Signals that we're starting a new test case.
	 */
	protected static void startingTestCase() {
		testTypeFailed = false;
	}
	
	/**
	 * Reports an error for the current test case.
	 *
	 * @param msg the message to display on the console.
	 */
	protected static void reportError(String msg) {
		System.out.print("!!! ");
		System.out.println(msg);
		testTypeFailed = true;
	}
	
	/**
	 * Signals that we've finished the current test case.
	 */
	protected static void finishingTestCase() {
		if (testTypeFailed) {
			System.out.println("Test failures.  See above for details.");
			System.out.println();
			fail("Test failures.  See console for details.");
		}
		System.out.println();
	}
	
	/**
	 * Checks to make sure that the list of words or lines returned from either
	 * Chain.getWords() or Chain.getWrappedLines() is non-empty.
	 *
	 * @param chainLines A list of words or lines returned from a Markov Chain.
	 */
	protected static void checkChainResult(ArrayList<String> chainLines) {
		if (chainLines.isEmpty()) {
			reportError("Expected a non-empty list of lines or words.");
			finishingTestCase();
		}
	}
}
