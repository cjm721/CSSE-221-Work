package memoization;


/**
 * Demos Fibonacci run times with and without memoization.
 *
 * @author Matt Boutell.
 *         Created Oct 6, 2010.
 */
public class Fibonacci {

	private static long[] fibTable;
	
	/**
	 * Starts here.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO: 1 Run the program and look at the runtimes. For how large a fibonacci number can you 
		// compute in less than 5 seconds using the basic fib function? What about the 
		// memoizedFib function?
		// TODO 2: Make sure you understand how to memoize a recursive function.
		int n = 30;
		long fibbed = 0;
		long elapsedTime = 0;
        long start, end;
        
        start = System.currentTimeMillis(); 
     // n+1 since we need room for fibs from 1 - n and don't feel like subtracting 1 from the indices
        fibTable = new long[n+1]; 
        fibbed = memoizedFib(n);
        end = System.currentTimeMillis(); 		
        elapsedTime = end - start;
		System.out.printf("Memoized fib(%d) = %d ", n, fibbed);
		System.out.println("Time = " + elapsedTime + " ms.");
        
        start = System.currentTimeMillis();                              
        fibbed = fib(n);
        end = System.currentTimeMillis();		
        elapsedTime = end - start;
		System.out.printf("Basic fib(%d) = %d ", n, fibbed);
		System.out.println("Time = " + elapsedTime + " ms.");
   	}

	/**
	 * Computes the nth number (starting with fib(1) = fib(2) = 1) in the Fibonacci sequence.
	 * Precondition: n >= 1
	 * Uses memoization for speed
	 * @param n
	 * @return fib(n)
	 */
	private static long memoizedFib(int n) {
		if (n <= 2) {
			return 1;
		} 

		if (fibTable[n] > 0)
			return fibTable[n];
		
		fibTable[n] =memoizedFib(n-1) + memoizedFib(n-2);
		return fibTable[n];
	}

	/**
	 * Computes the nth number (starting with fib(1) = fib(2) = 1) in the Fibonacci sequence.
	 * Precondition: n >= 1
	 * @param n
	 * @return fib(n)
	 */
	private static long fib(int n) {
		if (n <= 2) {
			return 1;
		} 
		return fib(n-1) + fib(n-2);
	}

}
