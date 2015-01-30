package facebook;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the constructor and methods of the {@link FaceBookUser} class.
 * 
 * @author defoe. Created Oct 2, 2013.
 */
public class FacebookUserTest {

	private FacebookUser tom;

	private FacebookUser jane;

	private FacebookUser sammy;

	private FacebookUser rob;

	private FacebookUser john;

	private String[] messages = {
			"I went to the home coming pep rally and it was fun",
			"Did you experience the bunfire?",
			"I heard that the physics did not work", "It fell to the side",
			"no", "yah", "not cool" };
	
	private static int points = 0;

	/**
	 * Setup some objects for testing.
	 * 
	 */
	@Before
	public void setUp() {
		this.tom = new FacebookUser("Thomas");
		this.jane = new FacebookUser("Jane");
		this.sammy = null;
		this.rob = new FacebookUser("Robert");
		this.john = new FacebookUser("John");
	}

	/**
	 * Test that setUp works. Should be able to initialize all these objects in
	 * setUp().
	 * 
	 */
	@Test
	public void testSetUpWorks() {
		assertNotNull(this.tom.getPosts());
		assertEquals(this.tom.getName(), "Thomas");
		assertNotNull(this.jane.getPosts());
		assertEquals(this.jane.getName(), "Jane");
		assertNotNull(this.rob.getPosts());
		assertEquals(this.rob.getName(), "Robert");
		FacebookUserTest.points += 2;
		assertNull(this.sammy);
		FacebookUserTest.points += 1;
	}

	/**
	 * Test the {@link FacebookUser#addMessage(java.util.ArrayList, String)}
	 * 
	 */
	@Test
	public void TestAddMessage() {
		assertEquals(0, this.rob.getPosts().size());
		this.rob.addMessage(this.rob.getPosts(), this.messages[2]);
		assertEquals(1, this.rob.getPosts().size());

		this.rob.addMessage(this.rob.getPosts(), this.messages[4]);
		assertEquals(2, this.rob.getPosts().size());
	}

	/**
	 * Test the {@link FacebookUser#addFriend(FacebookUser)} method.
	 * 
	 */
	@Test
	public void testAddFriend() {
		assertTrue(this.tom.addFriend(this.jane));
		assertTrue(this.tom.addFriend(this.rob));
		FacebookUserTest.points +=1;
		assertFalse(this.rob.addFriend(this.sammy));
		FacebookUserTest.points +=1;
		assertTrue(this.jane.addFriend(this.rob));
		assertFalse(this.rob.addFriend(null));
		FacebookUserTest.points +=1;
	}

	/**
	 * Test the {@link FacebookUser#attemptToPostMessage(FacebookUser, String)}
	 * method.
	 * 
	 */
	@Test
	public void TestAttemptToPostMessage() {
		this.tom.addFriend(this.jane);
		this.tom.addFriend(this.rob);
		assertEquals(this.messages[0],
				this.tom.attemptToPostMessage(this.jane, this.messages[0]));
		FacebookUserTest.points +=1;
		assertEquals(this.messages[1],
				this.tom.attemptToPostMessage(this.jane, this.messages[1]));
		FacebookUserTest.points +=1;
		assertNull(this.tom.attemptToPostMessage(this.jane, this.messages[5]));
		FacebookUserTest.points +=1;
		assertNull(this.tom.attemptToPostMessage(this.sammy, this.messages[6]));
		FacebookUserTest.points +=1;
		assertNull(this.tom.attemptToPostMessage(this.john, this.messages[2]));
		FacebookUserTest.points +=1;
		assertEquals(2, this.tom.getPosts().size());
		FacebookUserTest.points +=1;
	}

	/**
	 * Test the
	 * {@link MaliciousFacebookUser#attemptToPostMessage(FacebookUser, String)}
	 * method.
	 * 
	 */
	@Test
	public void TestOtherAttemptToPostMessage() {
		FacebookUser suzzy = new MaliciousFacebookUser("Susan");
		FacebookUser frank = new MaliciousFacebookUser("Franklin");
		this.tom.addFriend(suzzy);
		this.tom.addFriend(frank);
		assertEquals(0, this.tom.getPosts().size());
		FacebookUserTest.points +=1;
		assertEquals(this.messages[0],
				this.tom.attemptToPostMessage(suzzy, this.messages[0]));
		FacebookUserTest.points +=2;
		assertEquals(2, this.tom.getPosts().size());
		FacebookUserTest.points +=1;
		assertEquals(this.messages[1],
				this.tom.attemptToPostMessage(frank, this.messages[1]));

		assertEquals(6, this.tom.getPosts().size());
		FacebookUserTest.points +=2;
	}
	
	/**
	 * Display the total points for completing the implementation of the Facebook user system.
	 *
	 */
	@After
	public void printPoints(){
		System.out.println("Your total points is " + FacebookUserTest.points + " out of a maximum 18 points.");
	}
	

}
