import java.util.Scanner;

/**
 * TODO A representation of a Date object in the format
 * month, day, year.
 *
 * @author Matt Boutell, edited by Delvin Defoe.
 *         Created Sep 14, 2010.
 */
public class Date {
	/**
	 * The month of the year
	 */
	private String month;

	/**
	 * The date in that month
	 */
	private int day;
	
	/**
	 * The four digit year 
	 */
	private int year; 

	/**
	 * 
	 * TODO Constructs a default Date object.
	 *
	 */
	public Date() {
		this.month = "January";
		this.day = 1;
		this.year = 1000;
	}

	/**
	 * 
	 * TODO Constructs a Date object with the given parameters.
	 * The month is given as an int.
	 *
	 * @param monthInt
	 * @param day
	 * @param year
	 */
	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}

	/**
	 * 
	 * TODO Constructs a Date object with the given parameters.
	 * The month is given as a string
	 *
	 * @param monthString
	 * @param day
	 * @param year
	 */
	public Date(String monthString, int day, int year) {
		setDate(monthString, day, year);
	}

	/**
	 * 
	 * TODO Constructs a Date object with the given parameter.
	 *
	 * @param year
	 */
	public Date(int year) {
		setDate(1, 1, year);
	}

	/**
	 * 
	 * TODO Construct a new Date object from the given Date object.
	 *
	 * @param aDate
	 */
	public Date(Date aDate) {
		if (aDate == null)//Not a real date.
		{
			System.out.println("Fatal Error.");
			System.exit(0);
		}

		this.month = aDate.month;
		this.day = aDate.day;
		this.year = aDate.year;
	}

	/**
	 * 
	 * TODO Initialize the fields of this Date object with the given parameters.
	 *
	 * @param monthInt
	 * @param day
	 * @param year
	 */
	public void setDate(int monthInt, int day, int year) {
		if (dateOK(monthInt, day, year)) {
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	/**
	 * 
	 * TODO Initialize the fields of this Date object with the given parameters.
	 *
	 * @param monthString
	 * @param day
	 * @param year
	 */
	public void setDate(String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	/**
	 * 
	 * TODO Initialize the fields of this Date object with the given parameters.
	 *
	 * @param year
	 */
	public void setDate(int year) {
		setDate(1, 1, year);
	}

	/**
	 * 
	 * TODO Initialize the year field with the given parameter.
	 *
	 * @param year
	 */
	public void setYear(int year) {
		if ((year < 1000) || (year > 9999)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.year = year;
	}

	/**
	 * 
	 * TODO Initialize the month field with the given parameter.
	 *
	 * @param monthNumber
	 */
	public void setMonth(int monthNumber) {
		if ((monthNumber <= 0) || (monthNumber > 12)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.month = monthString(monthNumber);
	}

	/**
	 * 
	 * TODO Initialize the day field with the given parameter
	 *
	 * @param day
	 */
	public void setDay(int day) {
		if ((day <= 0) || (day > 31)) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else
			this.day = day;
	}

	/**
	 * 
	 * TODO Return the month value for this Date object.
	 *
	 * @return month
	 */
	public int getMonth() {
		if (this.month.equals("January"))
			return 1;
		else if (this.month.equals("February"))
			return 2;
		else if (this.month.equalsIgnoreCase("March"))
			return 3;
		else if (this.month.equalsIgnoreCase("April"))
			return 4;
		else if (this.month.equalsIgnoreCase("May"))
			return 5;
		else if (this.month.equalsIgnoreCase("June"))
			return 6;
		else if (this.month.equalsIgnoreCase("July"))
			return 7;
		else if (this.month.equalsIgnoreCase("August"))
			return 8;
		else if (this.month.equalsIgnoreCase("September"))
			return 9;
		else if (this.month.equalsIgnoreCase("October"))
			return 10;
		else if (this.month.equals("November"))
			return 11;
		else if (this.month.equals("December"))
			return 12;
		else {
			System.out.println("Fatal Error");
			System.exit(0);
			return 0; //Needed to keep the compiler happy
		}
	}

	/**
	 * 
	 * TODO Return the day value for this Date object.
	 *
	 * @return day
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * 
	 * TODO Return the year value for this Date object.
	 *
	 * @return year
	 */
	public int getYear() {
		return this.year;
	}

	@Override
	public String toString() {
		return (this.month + " " + this.day + ", " + this.year);
	}

	
	/**
	 * TODO Determines whether the given date object is equal to this Date object.
	 * Two date objects are equal if the values of their fields are equal.
	 *
	 * @param otherDate
	 * @return true if equal, false otherwise
	 */
	public boolean equals(Date otherDate) {
		if (otherDate == null)
			return false;
		else
			return ((this.month.equals(otherDate.month)) && 
					(this.day == otherDate.day) && 
					(this.year == otherDate.year));
	}

	/**
	 * 
	 * TODO Determines whether this Date precedes the given Date.
	 *
	 * @param otherDate
	 * @return true if this Date precedes the given Date
	 */
	public boolean precedes(Date otherDate) {
		return ((this.year < otherDate.year) || 
				(this.year == otherDate.year && getMonth() < otherDate.getMonth()) || 
				(this.year == otherDate.year && this.month.equals(otherDate.month) && this.day < otherDate.day));
	}

	/**
	 * 
	 * TODO Receive and process input from the user.
	 *
	 */
	public void readInput() {
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		while (tryAgain) {
			System.out.println("Enter month, day, and year.");
			System.out.println("Do not use a comma.");
			String monthInput = keyboard.next();
			int dayInput = keyboard.nextInt();
			int yearInput = keyboard.nextInt();
			if (dateOK(monthInput, dayInput, yearInput)) {
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;
			} else
				System.out.println("Illegal date. Reenter input.");
		}
	}

	/**
	 * 
	 * TODO Determine whether the given parameters represent a valid Date.
	 *
	 * @param monthInt
	 * @param dayInt
	 * @param yearInt
	 * @return true if the date represented is valid
	 */
	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1)
				&& (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
	}

	/**
	 * 
	 * TODO Determine whether the given parameters represent a valid Date.
	 *
	 * @param monthString
	 * @param dayInt
	 * @param yearInt
	 * @return true if the date represented is valid
	 */
	private boolean dateOK(String monthString, int dayInt, int yearInt) {
		return (monthOK(monthString) && (dayInt >= 1) && (dayInt <= 31)
				&& (yearInt >= 1000) && (yearInt <= 9999));
	}

	/**
	 * 
	 * TODO Determine whether the given parameter represents a valid month.
	 *
	 * @param month
	 * @return true if the month represented is valid
	 */
	private boolean monthOK(String month) {
		return (month.equals("January") || month.equals("February")
				|| month.equals("March") || month.equals("April")
				|| month.equals("May") || month.equals("June")
				|| month.equals("July") || month.equals("August")
				|| month.equals("September") || month.equals("October")
				|| month.equals("November") || month.equals("December"));
	}

	/**
	 * 
	 * TODO Return a String that represents the given month.
	 *
	 * @param monthNumber
	 * @return String representation of the given month
	 */
	private String monthString(int monthNumber) {
		switch (monthNumber) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.out.println("Fatal Error");
			System.exit(0);
			return "Error"; //to keep the compiler happy
		}
	}
}
