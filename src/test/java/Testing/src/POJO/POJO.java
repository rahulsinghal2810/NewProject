package Testing.src.POJO;

import java.lang.reflect.Field;
import java.net.URLEncoder;

public class POJO {

	@SuppressWarnings("deprecation")
	public String toUrlEncode()
	{
		String url = "";
		int count = 0;
		for(Field field : this.getClass().getDeclaredFields())
			try {
				if(field.get(this) !=null)
				{
					if(count == 0)
						url = url + "?";
					else
						url = url + "&";
					
					url = url + URLEncoder.encode(field.getName()) + "=" + URLEncoder.encode(field.get(this).toString());
					count++;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}		
		return url;
	}
	
}
