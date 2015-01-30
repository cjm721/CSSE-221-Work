package facebook;

import java.util.ArrayList;

/**
 * A Facebook user has a name, zero or more friends who are also Facebook users,
 * and zero or more posts (made by Facebook friends) on their Facebook time
 * line.
 * 
 * @author millerc5. Created Oct 4, 2013.
 */
public class FacebookUser {

	private String name;
	private ArrayList<String> posts;
	private ArrayList<FacebookUser> friends;

	/**
	 * 
	 * Constructs a Facebook user with the given name.
	 * 
	 * @param name
	 *            The name of this user.
	 */
	public FacebookUser(String name) {
		this.name = name;
		this.posts = new ArrayList<String>();
		this.friends = new ArrayList<FacebookUser>();
	}

	/**
	 * 
	 * Adds a Facebook user to this user's list of friends.
	 * 
	 * @param usr
	 *            The Facebook user to add as a friend.
	 * @return true if friend is successfully added, false otherwise.
	 */
	public boolean addFriend(FacebookUser usr) {
		if(usr == null) return false;
		if(this.friends.contains(usr)){
			return false;
		}
		return this.friends.add(usr);
	}

	/**
	 * 
	 * If the poster is a Facebook user who happens to be a friend of this user,
	 * then the poster is allowed to post a message that is longer than 3
	 * non-white space characters (except when they appear between words) to
	 * this user's time line. A posting is done by displaying the poster's name
	 * and message to the console and returning the message text. Otherwise,
	 * nothing is displayed and null is returned.
	 * 
	 * All successful posts are stored.
	 * 
	 * @param poster
	 *            A Facebook user who is a friend of this user.
	 * @param msg
	 *            A message that is longer than 3 non-white characters.
	 * @return the message or null.
	 */
	public String attemptToPostMessage(FacebookUser poster, String msg) {
		if(msg == null) return null;
		if(this.friends.contains(poster)){
			if(msg.trim().length() > 3){
				poster.addMessage(this.posts, msg);
				return msg;
			}
		}
		return null;
	}

	/**
	 * 
	 * Actually posts the message and store it in this list of successful posts.
	 * This is really a helper method that {@link #attemptToPostMessage}
	 * invokes. This method does not verify that the message is well formed.
	 * 
	 * In practice it is better to implement this as a private method, but we
	 * give it the protected visibility here for convenience.
	 * 
	 * @param posts
	 *            The list of posts to add message to.
	 * @param msg
	 *            The message to add to given list of posts.
	 */
	protected void addMessage(ArrayList<String> posts, String msg) {
		/*
		 * Print the poster's name and the message before adding it to the given
		 * list of posts.
		 */
		System.out.println(this.getName() + ": " + msg);
		posts.add(msg);
	}

	/**
	 * 
	 * @return the name of this Facebook user.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return the list of successful posts made to this user's time line.
	 */
	public ArrayList<String> getPosts() {
		return this.posts;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof FacebookUser)) {
			return false;
		}
		FacebookUser usr = (FacebookUser) o;
		if (this.name.equals(usr.name) && this.posts.size() == usr.posts.size()
				&& this.friends.size() == usr.friends.size()) {
			for (int i = 0; i < this.posts.size(); i++) {
				if (!(this.posts.get(i)).equals(usr.posts.get(i))) {
					return false;
				}
			}
			for (int i = 0; i < this.friends.size(); i++) {
				if (!(this.friends.get(i).getName()).equals(usr.friends.get(i)
						.getName())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
