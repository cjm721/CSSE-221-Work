import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Tests cases for Markov project, milestone 1.
 * 
 * @author Curt Clifton Created Dec 3, 2007.
 */
public class Milestone1Tests extends MarkovTests {
	// Matches any string of 1 or more whitespace characters.
	private static final Pattern WHITESPACES = Pattern.compile("\\s+");

	/**
	 * Removes from subchains any subchains of the given length that appear in
	 * the given file.
	 * 
	 * @param subchains
	 * @param fileName
	 * @param subchainLength
	 * @return the last word in the file
	 * @throws IOException
	 */
	private static String removeValidSuffixes(HashSet<String> subchains,
			String fileName, int subchainLength) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		FixedLengthQueue q = new FixedLengthQueue(subchainLength);
		String line;
		String theLastWord = "";
		while ((line = r.readLine()) != null) {
			String[] lineWords = WHITESPACES.split(line);
			for (String w : lineWords) {
				if (w.length() != 0) {
					theLastWord = w;
					q.add(w);
					subchains.remove(q.toString());
				}
			}
		}
		// You can have it...
		return theLastWord;
	}

	/**
	 * Tests for valid Markov suffixes.
	 * 
	 * @throws IOException
	 */
	public void testMarkovSuffix() throws IOException {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			System.out.println("Testing chains for " + parms.fileName);
			Chain ch = chainFromParms(parms);

			// Creates a set of all the subchains of length prefixLength + 1,
			// and counts the output words at the same time.
			ArrayList<String> words = ch.getWords();
			checkChainResult(words); // Makes sure a non-empty list of words is returned
			
			HashSet<String> subchains = new HashSet<String>();
			FixedLengthQueue q = new FixedLengthQueue(parms.prefixLength + 1);
			int wordCount = 0;
			for (String word : words) {
				q.add(word);
				wordCount++;
				if (wordCount > parms.prefixLength + 1) {
					subchains.add(q.toString());
				}
			}

			// Removes valid suffixes from list so only errors remain.
			String theLastWord = removeValidSuffixes(subchains, parms.fileName,
					parms.prefixLength + 1);
			if (!subchains.isEmpty()) {
				reportError("Invalid subchains present in result:\n"
						+ subchains.toString());
			}
			/* Replaced by checkChainResult(words) above
			if (words.size() <= 0) {
				reportError("Expected some words, but none were returned.");
				finishingTestCase();
			}*/
			String lastWordOutput = words.get(words.size() - 1);
			if (!lastWordOutput.equals(theLastWord)) {
				// Last word output is not last word in file, so algorithm did
				// not end naturally.
				if (wordCount != parms.maxWords) {
					reportError("Last word output, '" + lastWordOutput
							+ "' is not the last word in the file, but maximum"
							+ " word count of " + parms.maxWords
							+ " was not reached.");
				}
			} else {
				if (wordCount > parms.maxWords) {
					reportError("Number of words, " + words.size()
							+ ", exceeds maximum of " + parms.maxWords);
				}
			}
		}
		finishingTestCase();
	}

	/**
	 * Tests for random sequences.
	 * 
	 * @throws IOException
	 */
	public void testMarkovRandom() {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			if (parms.testRandomization) {
				System.out.println("Testing randomization for "
						+ parms.fileName);
				Chain ch1 = chainFromParms(parms);
				ArrayList<String> words1 = ch1.getWords();
				checkChainResult(words1); // Makes sure a non-empty list of words is returned
				Chain ch2 = chainFromParms(parms);
				ArrayList<String> words2 = ch2.getWords();
				checkChainResult(words2); // Makes sure a non-empty list of words is returned
				if (words1.equals(words2)) {
					reportError("It appears that the chain generated for file '"
							+ parms.fileName
							+ "' is non-random.  Run tests again to be sure.  "
							+ "Perhaps you were just unlucky.");
				}
			}
		}
		finishingTestCase();
	}

}
