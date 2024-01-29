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
		return olmh;
	}
	
}
