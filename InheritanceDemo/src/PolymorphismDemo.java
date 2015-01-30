/**
 *  Warning: the Javadoc is scarce in the this toy program.
 *  
 *
 *	TODO  ADD_YOUR_NAME and provide missing Javadoc comments.
 *	See Date and Employee for ideas.
 * 
 */ 
public class PolymorphismDemo {
	public static void main(String[] args) {
		// create a list of employees
		int nEmployees = 4;
		Employee[] employees = new Employee[nEmployees];
		
		employees[0] = new HourlyEmployee("Joe Worker", new Date(
				"January", 1, 2004), 10.50, 160);
		employees[1] = new HourlyEmployee("Wilma Worker", new Date(
				"October", 16, 2005), 12.50, 170);
		employees[2] = new SalariedEmployee("Mark Manager", new Date(
				"June", 4, 2006), 40000);
		employees[3] = new SalariedEmployee("Ellie Executive", new Date(
				"March", 17, 2002), 60000);

		// print every employee's info
		for (int i = 0; i < nEmployees; i++) {
			System.out.println(employees[i]);
		}
		
		// print every employee's pay
	}
}
