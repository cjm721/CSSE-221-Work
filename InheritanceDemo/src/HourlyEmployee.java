/**
 *	Class Invariant: All objects have a name string, hire date, nonnegative 
 *	wage rate, and nonnegative number of hours worked. A name string of 
 *	"No name" indicates no real name specified yet. A hire date of Jan 1, 1000 
 *	indicates no real hire date specified yet.
 *
 *
 *	TODO  ADD_YOUR_NAME and provide missing Javadoc comments.
 *
 */
public class HourlyEmployee extends Employee {
	private double wageRate;
	private double hours; //for the month

	public HourlyEmployee() {
		super();
		this.wageRate = 0;
		this.hours = 0;
	}

	public HourlyEmployee(String name, Date date, double wageRate,
			double hours) {
		super(name, date);
		// Could error-trap negative rates or hours.
		this.wageRate = wageRate;
		this.hours = hours;
	}

	public HourlyEmployee(HourlyEmployee original) {
		super(original);
		this.wageRate = original.wageRate;
		this.hours = original.hours;
	}

	public double getRate() {
		return this.wageRate;
	}

	public double getHours() {
		return this.hours;
	}

	@Override
	public double getMonthlyPay() {
		return this.wageRate * this.hours;
	}

	public void setHours(double hoursWorked) {
		if (hoursWorked >= 0)
			this.hours = hoursWorked;
		else {
			System.out.println("Fatal Error: Negative hours worked.");
			System.exit(0);
		}
	}

	public void setRate(double newWageRate) {
		if (newWageRate >= 0)
			this.wageRate = newWageRate;
		else {
			System.out.println("Fatal Error: Negative wage rate.");
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		String s = super.toString() + String.format("\n$%5.2f per hour for %3.1f hours", 
				this.wageRate, this.hours);
				return s; 
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof HourlyEmployee)) {
			return false;
		}
		HourlyEmployee other = (HourlyEmployee)object;
		return super.equals(object) 
			&& this.wageRate ==  other.wageRate && this.hours == other.hours;
	}
}
