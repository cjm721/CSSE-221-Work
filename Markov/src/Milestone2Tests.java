import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tests cases for Markov project, milestone 2.
 * 
 * @author Curt Clifton Created Dec 3, 2007.
 */
public class Milestone2Tests extends MarkovTests {
	// Matches period, exclamation point, or question mark, followed by a space,
	// followed by something that is not a space.
	private static final Pattern BAD_END_OF_SENTENCE = Pattern
			.compile("(\\.|\\!|\\?) \\S");

	// Matches any non-empty sequence of non-space characters.
	private static final Pattern NOT_SPACES = Pattern.compile("\\S+");

	// Matches the first word of a line.
	private static final Pattern FIRST_WORD = Pattern.compile("^\\S+");

	/**
	 * Tests line length.
	 */
	public void testMarkovLineLength() {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			System.out.println("Testing line length for " + parms.fileName);
			Chain ch = chainFromParms(parms);
			ArrayList<String> lines = ch.getWrappedLines();
			checkChainResult(lines); // Makes sure a non-empty list of lines is returned 
			/* Replaced by call to checkChainResult(lines) above
			if (lines.isEmpty()) {
				reportError("Expected non-empty list of lines.");
				finishingTestCase();
			}*/
			// Checks length of all but the last line
			for (int i = 0; i < lines.size() - 1; i++) {
				int lineLength = lines.get(i).length();
				if (lineLength != parms.justificationWidth)
					reportError("Expected line length to be "
							+ parms.justificationWidth + " in line "
							+ lines.get(i) + ", was " + lineLength);
			}
			int lastLineLength = lines.get(lines.size() - 1).length();
			if (lastLineLength > parms.justificationWidth) {
				reportError("Expected last line length to be no more than "
						+ parms.justificationWidth + ".  It was "
						+ lastLineLength);
			}
		}
		finishingTestCase();
	}

	/**
	 * Tests spaces after sentence-ending punctuation.
	 */
	public void testMarkovPunctuation() {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			System.out.println("Testing after-space punctuation for "
					+ parms.fileName);
			Chain ch = chainFromParms(parms);
			ArrayList<String> lines = ch.getWrappedLines();
			checkChainResult(lines); // Makes sure a non-empty list of lines is returned
			for (String l : lines) {
				Matcher m = BAD_END_OF_SENTENCE.matcher(l);
				if (m.find()) {
					reportError("Expected at least two spaces after "
							+ "sentence-ending punctuation in line: " + l);
				}
			}
		}
		finishingTestCase();
	}

	/**
	 * Tests distribution of blank space.
	 */
	public void testMarkovBlanks() {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			System.out.println("Testing distribution of blanks for "
					+ parms.fileName);
			Chain ch = chainFromParms(parms);
			ArrayList<String> lines = ch.getWrappedLines();
			checkChainResult(lines); // Makes sure a non-empty list of lines is returned
			for (String l : lines) {
				String[] blanks = NOT_SPACES.split(l);
				// first entry is always empty string
				if (blanks.length > 1) {
					int minBlankLength = blanks[1].length();
					int maxBlankLength = blanks[1].length();
					for (int i = 1; i < blanks.length; i++) {
						String b = blanks[i];
						minBlankLength = b.length() < minBlankLength ? b
								.length() : minBlankLength;
						maxBlankLength = b.length() > maxBlankLength ? b
								.length() : maxBlankLength;
					}
					// Condition is 2 not 1 to accommodate extra spaces after
					// sentence-ending punctuation.
					if (maxBlankLength - minBlankLength > 2) {
						reportError("Uneven distribution of spaces in line: '"
								+ l + "'");
					}
				}
			}
		}
		finishingTestCase();
	}

	/**
	 * Tests line wrapping.
	 */
	public void testMarkovWrap() {
		startingTestCase();
		for (MarkovTests.Parameters parms : TEST_PARAMETERS) {
			System.out.println("Testing word wrapping for " + parms.fileName);
			Chain ch = chainFromParms(parms);
			ArrayList<String> lines = ch.getWrappedLines();
			checkChainResult(lines); // Makes sure a non-empty list of lines is returned
			for (int i = 0; i < lines.size() - 1; i++) {
				String smooshedLine = smooshLine(lines.get(i));
				String nextWord = firstWord(lines.get(i + 1));
				int lineLengthWithNextWord = smooshedLine.length()
						+ nextWord.length();
				if (lineLengthWithNextWord <= parms.justificationWidth) {
					reportError("There was room for '" + nextWord + "' on the line: "
							+ lines.get(i));
				}
			}
		}
		finishingTestCase();
	}

	// Finds the first word on the given line
	private String firstWord(String line) {
		Matcher m = FIRST_WORD.matcher(line);
		if (m.find()) {
			return line.substring(0, m.end());
		} else {
			return line;
		}
	}

	// Returns a new line with all extraneous spaces removed.
	private String smooshLine(String line) {
		// Collapses all multiple space runs to single spaces
		line = line.replaceAll("\\s+", " ");

		// Ensures an end-of-line space
		if (!line.endsWith(" ")) {
			line = line + " ";
		}

		// Double the spaces after punctuation
		line = line.replaceAll("\\. ", ".  ");
		line = line.replaceAll("\\! ", ".  ");
		line = line.replaceAll("\\? ", ".  ");
		return line;
	}

}
