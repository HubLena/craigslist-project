package CraiglistSearch;

public class JavaPosition {
	private String title;
	private String demographic;
	private String postedDate;

	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDemographic() {
		return demographic;
	}
	public void setDemographic(String demographic) {
		this.demographic = demographic;
	}
	
	public JavaPosition(String posteddate, String title, String demographic) {
		this.postedDate = posteddate;
		this.title = title;
		this.demographic = demographic;
	}
	public JavaPosition() {
		this.postedDate = "No Date";
		this.title = "No Title";
		this.demographic = "No demographic";
	}
	
	
	@Override
	public String toString() {
		// Create a StringBuffer and attach valuable information
		StringBuffer sb = new StringBuffer();
		sb.append(" Posted date is ");
		sb.append(getPostedDate() + " ");
		sb.append(getTitle());
		sb.append(" location is ");
		sb.append(getDemographic());
		// Return the content of the StringBuffer as a String
		return sb.toString();
	}

}
