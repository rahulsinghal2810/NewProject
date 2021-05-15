package Testing.src.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Stack;

import org.testng.TestNG;
import org.testng.annotations.Test;

import Testing.src.Helper.APIHelper;
import Testing.src.Helper.APIProperties.APIName;
import Testing.src.Helper.APIProperties.APIReponseStatus;
import Testing.src.Helper.APIProperties.APIRequestType;
import Testing.src.POJO.User_old;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestingUser_old extends TestNG{
	
	@Test
	public void TestCase1()
	{
		User_old user = new User_old("1");
		APIHelper apiHelper = new APIHelper(APIName.fetch, user.toUrlEncode(), null, APIRequestType.GET, ContentType.TEXT,null);
		Response response = apiHelper.execute();
		apiHelper.verifyReponse(response, APIReponseStatus.sucess, "HTTP/1.1 200 OK", ContentType.TEXT);
		User_old user2 = response.as(User_old.class);
		System.out.println(user2.getUserId() + " "+ user2.getName());
	}
	
	public static void main(String[] args) {
		/*HashMap <Integer, Integer> map = new HashMap<Integer,Integer>();
		map.put(1, 10);
		map.put(2, 11);
		map.put(3, 12);
		map.put(4, 13);
		for(Map.Entry mapElement : map.entrySet())
		{
			System.out.println(mapElement.getKey());
			System.out.println(mapElement.getValue());
		}*/
		
		/*ArrayList <Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(1);
		arrlist.add(3);
		arrlist.add(5);
		
		for(int i = 0 ; i < arrlist.size(); i++)
		{
			System.out.println(arrlist.get(i));
		}
		*/
		
		
		//subarray();
		int arr[] = {4,4,1,2,3};
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maxValue = 0;
		for(int element: arr)
		{
			if(element> maxValue)
				maxValue = element;
			
			if(map.containsKey(element))
				map.put(element, map.get(element)+1);
			else
				map.put(element, 1);
		}		
		DecimalFormat df = new DecimalFormat("##############.####");
		System.out.println(df.format(0.55555));
	}
	
	public boolean isValid(String s) 
	{
        
        HashMap <Character,Character>mappings = new HashMap<Character,Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i< s.length(); i++)
        {
        		if(mappings.containsKey(s.charAt(i)))
        		{
        			Character topElement;
        			if(!stack.isEmpty())
        			{
        				topElement = stack.pop();
        				if(topElement != mappings.get(s.charAt(i)))
        					return false;        					
        			}
        		}
        		else
        		{
        			stack.push(s.charAt(i));
        		}
        }
        return stack.isEmpty();
    }
	
	
	/**
	 * WAP to find count of sub-arrays in a given array having sum of element as 12
	 * {3,6,3,-3,3,2,12,-6,6,24,-12}
	 */
	
	public static void subarray()
	{
		int expSum = -10	;
		int arr[] = {10, 2, -2, -20, 10};
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			int sum = 0;
			for(int j = i ;j < arr.length ; j++)
			{
				sum = sum + arr[j];
				if(sum == expSum)
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	
	
	static int findSubarraySum(int arr[], int n, int sum)
    {
     
		/*
		 *  10, 2, -2, -20, 10
		 */
        HashMap<Integer, Integer> prevSum = new HashMap<Integer, Integer>();
  
        int res = 0;
        int currsum = 0;
  
        for (int i = 0; i < n; i++) {
            currsum += arr[i];
  
            if (currsum == sum)
                res++;
              
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);
  
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }  
        return res;
    }	
}
