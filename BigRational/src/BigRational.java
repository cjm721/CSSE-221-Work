import java.math.BigInteger;

/**
 * This class implements arbitrary precision rational numbers (i.e., fractions).
 * 
 * #FROM_GRADER make sure that your negatives are always on the numerator, and if there is a negative on top and bottom then remove them both.
 * 
 * @author millerc5.
 */
public class BigRational implements Comparable<BigRational>, ArithmeticObject<BigRational>{

	
	// TODO 8: Implement the ArithmeticObject methods in this order: abs,
	// negate, add, subtract, divide, multiply. Also write unit tests 
	// TODO 9: Implement compareTo.

	/**
	 * Stores the numerator of the BigRational.
	 */
	protected BigInteger numerator;

	/**
	 * Stores the denominator of the BigRational.
	 */
	protected BigInteger denominator;
	
	/**
	 * Constructs an arbitrary precision rational number with the given
	 * numerator and denominator.
	 * 
	 * 
	 * #FROM_GRADER don't just set the denominator = 1, throw an Arithmetic exception.
	 * @param numerator
	 * @param denominator
	 */
	public BigRational(String numerator, String denominator) {
		if(denominator.equals("0")){
			System.out.println("Cannot have a denominator of zero. Setting denominator to 1");
			this.denominator = BigInteger.ONE;
		}else{
			this.denominator = new BigInteger(denominator);
		}
		this.numerator = new BigInteger(numerator);
		
	}

	/**
	 * Constructs an arbitrary precision rational number with the given
	 * numerator and denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 */
	public BigRational(BigInteger numerator, BigInteger denominator){
		this.denominator = denominator;
		if(denominator.equals(BigInteger.ZERO)){
			System.out.println("Cannot have a denominator of zero. Setting denominator to 1");
			this.denominator = new BigInteger("1");
		}
		this.numerator = numerator;
		
	}

	/**
	 * Returns a String that represents this BigRational, as follows: If the
	 * BigRational is a whole number, the String is just that whole number.
	 * Otherwise, the String is "numerator/denominator" with the BigRational's
	 * numerator and denominator, in lowest terms. No spaces. If the BigRational
	 * is negative, the minus sign is displayed with the numerator (not the
	 * denominator).
	 */
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	/**
	 * Returns true if the given object is a BigRational that equals this
	 * BigRational. 
	 */
	@Override
	public boolean equals(Object object) {
		// equals is typically written with the following few lines of 
		// code at the beginning of it. 
		if (object == null || this.getClass() != object.getClass()) {
			return false;
		}
		BigRational other = (BigRational)object;
		if(other.numerator == this.numerator && other.denominator == this.denominator) 
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	@Override
	public int compareTo(BigRational other) {
		if(this.equals(other)) return 0;
		if(other.denominator.equals(BigInteger.ZERO)){
			System.out.println("Sending invalid BigInteger");
			return -2;
		}
		System.out.println(this.denominator + "  " + this.numerator);
		switch (this.numerator.divide(this.denominator).compareTo(other.numerator.divide(other.denominator))){
		case -1:
			return -1;
		case 0:
			return 0;
		case 1:
			return 1;
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see ArithmeticObject#abs()
	 */
	@Override
	public BigRational abs() {
		BigInteger newNum, newDen;
		if(this.numerator.compareTo(BigInteger.ZERO) < 0){
			newNum = this.numerator.negate();
		}else{
			newNum = this.numerator;
		}
		if(this.denominator.compareTo(BigInteger.ZERO) < 0){
			newDen = this.denominator.negate();
		}else{
			newDen = this.denominator;
		}
		return new BigRational(newNum,newDen);
	}

	/* (non-Javadoc)
	 * @see ArithmeticObject#negate()
	 */
	@Override
	public BigRational negate() {
		return new BigRational(this.numerator.multiply(new BigInteger("-1")),this.denominator);
	}

	/* (non-Javadoc)
	 * @see ArithmeticObject#add(java.lang.Object)
	 */
	@Override
	public BigRational add(BigRational other) {
		BigInteger gcd = this.denominator.multiply(other.denominator);
		BigInteger newNum = this.numerator.add(other.numerator.multiply(this.denominator));
		return new BigRational(newNum,gcd);
	}

	/* (non-Javadoc)
	 * @see ArithmeticObject#subtract(java.lang.Object)
	 */
	@Override
	public BigRational subtract(BigRational other) {
		BigInteger gcd = this.denominator.multiply(other.denominator);
		BigInteger newNum = this.numerator.subtract(other.numerator.multiply(this.denominator));
		return new BigRational(newNum,gcd);
	}

	/* (non-Javadoc)
	 * @see ArithmeticObject#divide(java.lang.Object)
	 */
	@Override
	public BigRational divide(BigRational other) throws ArithmeticException {
		if(this.denominator.equals(BigInteger.ZERO)){
			throw new ArithmeticException("Cannot divide by zero.");
		}
		//#FROM_GRADER this should not be exactly the same as multiply
		return new BigRational(this.numerator.multiply(other.numerator),this.denominator.multiply(other.denominator));
	}
	
	/* (non-Javadoc)
	 * @see ArithmeticObject#multiply(java.lang.Object)
	 */
	@Override
	public BigRational multiply(BigRational other) {
		return new BigRational(this.numerator.multiply(other.numerator),this.denominator.multiply(other.denominator));
	}


}
