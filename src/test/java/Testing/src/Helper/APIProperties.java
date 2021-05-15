package Testing.src.Helper;

public class APIProperties {
	
	public enum APIName {
		fetch("/users"),
		add("/add"),
		remove("/remove"),
		update("/update")
		;
		
		String path;
		APIName(String path)
		{
			this.path = path;
		}
		
		String getPath()
		{
			return path;
		}
	};
	
	
	public enum APIRequestType  {GET,POST};
	
	public enum APIReponseStatus  {
		sucess(200),failure(400),InternalServerError(500);		
		int responseCode;
		APIReponseStatus(int responseCode)
		{
			this.responseCode = responseCode;
		}
		int getAPIReponseCode()
		{
			return responseCode;
		}
	};

}
