package Testing.src.POJO;

public class User_old extends POJO{
	
	public String userId;
	public String name;

	public User_old(String userId)
	{
		this.userId = userId;
	}
	
	public User_old(String userId,String name)
	{
		this.userId = userId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
