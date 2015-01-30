import java.util.Scanner;

/**
 * A program to demo basics of exception handling by offering simple nutritional
 * advice.
 * 
 * @author Lisa C. Kaczmarczyk, modified by Matt Boutell. Created Sep 5, 2006.
 *         Modified by David Mutchler, Sep 15, 2008.
 */
public class Exceptions {

	/**
	 * Driver only.
	 * 
	 * @param args
	 *            Command-line arguments (unused)
	 */
	public static void main(String[] args) {
		Exceptions.getWeekday();
	}

	/*
	 * Tell the user what they get to eat based upon how well they follow
	 * directions.
	 */
	private static void getWeekday() {
		// find out if it is a weekday
		// and reward the user accordingly.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Use a number to tell me what weekday it is.");
		System.out
				.println("1-Monday, 2-Tuesday, 3-Wednesday, 4-Thursday, 5-Friday: ");

		int day = scanner.nextInt();

		try {
			if (day == 6 || day == 7) {
				throw new Exception(
						"Are you trying to say it is the weekend???");
			} else if (day > 7) {
				throw new Exception("There aren't that many days in a week");
			} else if (day < 1) {
				throw new Exception("Um...That makes no sense");
			}

			System.out
					.println("Because it is a weekday, you get to eat gummy bears. Good Job!");

			Exceptions.bugs(day);

		} catch (Exception exception) {
			String problem = exception.getMessage();
			System.out.println(problem + " - you have to eat brussel sprouts");

		} finally {
			System.out
					.println("Weekdays are suddenly looking much more appealing, aren't they?");
		}
	}

	/**
	 * This method simulates some buggy code. Leave it as it is.
	 * 
	 * @param day
	 *            Day that the user inputs.
	 */
	private static void bugs(int day) {
		int x = 500000000 * day; // Purposeful errors, leave them here.
		System.out.println("Five hundred million times 'day' is " + x);
		if (day == 3) {
			System.out.println(1 / 0);
		}
	}
}
