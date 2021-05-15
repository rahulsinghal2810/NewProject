package Testing.src.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import Testing.src.Helper.APIHelper;
import Testing.src.Helper.APIProperties.APIName;
import Testing.src.Helper.APIProperties.APIRequestType;
import io.restassured.http.ContentType;

public class TestUser {
	
	@Test
	public void TestGetSingleUser()
	{
		APIHelper apiHelper = new APIHelper(APIName.fetch, null, null, APIRequestType.GET, ContentType.JSON, null);
		apiHelper.execute();
		try {
			Connection con = DriverManager.getConnection("", "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
