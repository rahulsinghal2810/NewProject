package Testing.src.POJO;

public class User {
	
	public UserData data;
	public SupportData support;
	/**
	 * @return the data
	 */
	public UserData getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(UserData data) {
		this.data = data;
	}
	/**
	 * @return the support
	 */
	public SupportData getSupport() {
		return support;
	}
	/**
	 * @param support the support to set
	 */
	public void setSupport(SupportData support) {
		this.support = support;
	}
	public User(UserData data, SupportData support) {
		super();
		this.data = data;
		this.support = support;
	}
}
