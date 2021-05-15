package Testing.src.Test;

import java.util.HashMap;

public class Testing {
	public static void main(String[] args) {
		System.out.println("Hello");
		String str = removeDuplicate("abc bde abdf ffbg");
		System.out.println(str);
	}
	
	public static String removeDuplicate(String str)
	{
		System.out.println(str);
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0 ; i < str.length();i++)
		{
			char element = str.charAt(i);
			if(map.containsKey(element))
			{
				int value = map.get(element);
				map.put(element,value+1);	
			}
			else
			{
				map.put(element,1);
			}
		}
		String str2 = "";
		for(int i = 0; i < str.length();i++)
		{
			char element = str.charAt(i);
			if(element == ' ')
			{
				str2 = str2 + str.charAt(i);	
			}
			else if(map.containsKey(element))
			{
				map.remove(element);
				str2 = str2 + element;
			}
		}
		return str2;
	}

}

