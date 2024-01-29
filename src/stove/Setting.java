/*
 * 
 * Authors: Justin Pajela and Brody Perlick
 * Date:January 29, 2024
 * Collaborators: None
 * Outside Sources: None
 */
package stove;

public enum Setting {
	OFF ("---"), 
	LOW ("--+"), 
	MEDIUM ("-++"), 
	HIGH ("+++");
	private String olmh;
	Setting (String setting) {
		olmh = setting;
	}
	public String toString() { 
		return "[" + olmh + "].....";
	}
	
}
