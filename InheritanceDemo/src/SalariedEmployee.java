/**
 *  Warning: the Javadoc is scarce in the this toy program.
 *  
 *
 *	TODO  ADD_YOUR_NAME and provide missing Javadoc comments.
 *	See Date and Employee for ideas.
 * 
 */ 
public class SalariedEmployee extends Employee {
	private double salary;

	public SalariedEmployee() {
		this.salary = 0;
	}
	public SalariedEmployee(String name, Date date, double salary) {
		super(name, date);
		this.salary = salary;
	}
	public SalariedEmployee(SalariedEmployee salariedEmployee) {
		super(salariedEmployee);
		this.salary = salary;
	}
	@Override
	public double getMonthlyPay() {
		return this.salary / 12.0;
	}
}
