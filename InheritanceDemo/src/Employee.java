/**
 * Class Invariant: All objects have a name string and hire date. A name string
 * of "No name" indicates no real name specified yet. A hire date of Jan 1, 1000
 * indicates no real hire date specified yet.
 */
public abstract class Employee {
	/**
	 * The name of this Employee
	 */
	private String name;

	/**
	 * The hire Date for this Employee.
	 */
	private Date hireDate;

	/**
	 * 
	 * Constructs a default Employee. The assigned hire Date is just a place holder
	 *
	 */
	public Employee() {
		this.name = "No name";
		this.hireDate = new Date("January", 1, 1000); 
	}

	/**
	 * Precondition: Neither theName nor theDate is null.
	 * 
	 * Constructs an Employee with the given name and hire Date.
	 * 
	 * @param name 
	 * @param date 
	 */
	public Employee(String name, Date date) {
		if (name == null || date == null) {
			System.out.println("Fatal Error creating employee.");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = new Date(date);
	}

	/**
	 * 
	 * Constructs an Employee from the given Employee.
	 *
	 * @param original Employee
	 */
	public Employee(Employee original) {
		this.name = original.name;
		this.hireDate = new Date(original.hireDate);
	}

	/**
	 * 
	 * Return this Employee's name
	 *
	 * @return this Employee's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * Return the hire date for this Employee.
	 *
	 * @return the hire Date for this Employee
	 */
	public Date getHireDate() {
		return new Date(this.hireDate);
	}

	/**
	 * Precondition newName is not null.
	 * 
	 * Sets the name for this Employee to the given name.
	 * 
	 * @param newName 
	 */
	public void setName(String newName) {
		if (newName == null) {
			System.out.println("Fatal Error setting employee name.");
			System.exit(0);
		} else
			this.name = newName;
	}

	/**
	 * Precondition newDate is not null.
	 * 
	 * Sets the hire date for this Employee to the given Date.
	 * 
	 * @param newDate 
	 */
	public void setHireDate(Date newDate) {
		if (newDate == null) {
			System.out.println("Fatal Error setting employee hire date.");
			System.exit(0);
		} else
			this.hireDate = new Date(newDate);
	}

	
	@Override
	public String toString() {
		return (this.name + " " + this.hireDate.toString());
	}

	/**
	 * 
	 * TODO Determine whether the given Employee is equal to this Employee.
	 * Two employees are equal if their names and hire dates are the same.
	 *
	 * @param otherEmployee
	 * @return true if the Employees are equal
	 */
	public boolean equals(Employee otherEmployee) {
		return (this.name.equals(otherEmployee.name) && 
				this.hireDate.equals(otherEmployee.hireDate));
	}
	
	/**
	 * Return the monthly pay
	 * 
	 * @return monthly pay
	 */
	public abstract double getMonthlyPay();
}
