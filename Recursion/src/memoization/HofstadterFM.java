package memoization;
//FROM_GRADER: 10/10
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class implements Douglas Hofstadter's Female and Male sequences from
 * Godel, Escher, Bach.
 * 
 * @author Curt Clifton
 */
public class HofstadterFM {
	private static final int MAX = 5000000;
	static HashMap<Integer,Integer> female = new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> male = new HashMap<Integer,Integer>();
	
	//Diffrences:
	//50 	-> 8
	//500 	-> 13
	//5000	-> 18
	//5M	-> 32
	
	/**
	 * Starts the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int diffrence = 0;
		System.out.println("_i_ _F(i)_ _M(i)_");
		for (int i = 0; i <= MAX; i++) {
			final int f = f(i);
			female.put(i,f);
			final int m = m(i);
			male.put(i,m);
			if(f!=m) diffrence++;
			
			//System.out.printf("%3d %6d %6d\n", i, f, m);
			
		}System.out.println(diffrence);
	}

	private static int f(int n) {
		if(n==0) return 1;
		else if(female.get(n) != null){
			return female.get(n);
		}
		else{
			return n-m(f(n-1));
		}
	}

	private static int m(int n) {
		if(n==0) return 0;
		else if(male.get(n) != null){
			return male.get(n);
		}
		else{
			return n-f(m(n-1));
		}
	}
}
