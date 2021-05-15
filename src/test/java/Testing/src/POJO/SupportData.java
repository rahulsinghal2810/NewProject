package Testing.src.POJO;

public class SupportData {

	String text;
	String url;
	
	public SupportData(String text, String url) {
		super();
		this.text = text;
		this.url = url;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}	
}
