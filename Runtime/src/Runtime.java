/**
 * This program demonstrates the runtimes of various constructs.
 *
 * @author Matt Boutell.
 *         Created Sep 2, 2006.
 */
public class Runtime {

	private static double d = 0;

	/**
	 * Execution always starts in main().
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// Experiment with various values of num. 
		// They'll need to be fairly large to produce times
		// over 1 millisecond (1E6 nanoseconds).
		double num = 1E4;
		for(int a = 0; a < 7; a++){
			   
			long startTime = System.nanoTime();

			// Insert code here that you want to time.
			int i = 0;
			for(int j = 0; j < num; j++){
				Runtime.f(i+1);
			}for(int k = 0; k < num; k++){
				Runtime.f(i+1);
				
			}
			

			// Code that you want to time is above here.
			long stopTime = System.nanoTime();

			// Computes and displays elapsed time in nanoseconds
			long elapsedTime = stopTime - startTime;

			System.out.println("Done for n = " + num);
			System.out.println("Time = " + elapsedTime + " ns.");
			num *=10;
			
		}
		
	}

	/**
	 * Computing the sum of the harmonic series 
	 * just to waste some time in calling the method.
	 *
	 * @param i
	 */
	private static void f(double i) {
		d = d + 1.0/i;
	}

}
