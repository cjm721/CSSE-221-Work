package facebook;

import java.util.ArrayList;

/**
 * A Malicious Facebook user is an evil Facebook user that tricks their friends
 * by doubling the number of posts their friends have whenever they attempt to
 * post on their friends' time lines. They attempt to complete their posts
 * first, and if successful, they double the number of posts.
 * 
 * @author defoe. Created Oct 2, 2013.
 */
public class MaliciousFacebookUser extends FacebookUser {

	/**
	 * Constructs a MaliciousFacebookUser with the given name,
	 * 
	 * @param name
	 */
	public MaliciousFacebookUser(String name) {
		super(name);
	}


	/* (non-Javadoc)
	 * @see facebook.FacebookUser#addMessage(java.util.ArrayList, java.lang.String)
	 */
	@Override
	protected void addMessage(ArrayList<String> posts, String msg) {
		super.addMessage(posts, msg);
		int limit = posts.size();
		for(int i = 0; i < limit; i++){
			posts.add(posts.get(i));
		}
	}

}
