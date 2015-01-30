import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * TODO Put here a description of what this class does.
 *
 * @author millerc5.
 *         Created Sep 11, 2013.
 */
public class PigLatinerTest {
	

	
	/**
	 * Test method for {@link PigLatiner#transform(java.lang.String)}.
	 */
	@Test
	public void testTransform() {
		String[] send = {
				"fred", "stay", "a", "i", "fail", "a", "open", "ssss", null, " "
		};
		
		String[] answer = {
				"edfray", "aystay", "away", "iway", "ailfay", "away", "openway", "ssssay", null, " ay"
		};
		
		assertEquals("edfray", PigLatiner.transform("fred"));
		
		for(int i = 0; i < send.length; i++){
			try{
				assertEquals(answer[i], PigLatiner.transform(send[i]));
			}catch (Exception e){
				System.out.println("Failed on index: " + i);
				e.printStackTrace();
			}
			
		}
	}

}
