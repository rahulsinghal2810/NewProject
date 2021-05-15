package Testing.src.Test;

public class PracticeClass {
	
	/*
	 * Input: abcd1235 | Output: a-d1-35
	 * Iterate the charArray
	 * If(value of i == value(i+1) -1)
	 */
	public static void main(String args[]) {
		
		
		/*String str =  "ABCD1235";
		char c[] = str.toCharArray();
		String newStr = "";		
		int count = 0;
		
		for(int i  = 0 ;i<c.length ;)
		{
			String firstElement = "";
			String LastElement = "";
			count = 0;
			while(i<c.length)
			{		
				if(count ==0)
					firstElement = Character.toString(c[i]);
				int asciiValue = c[i];
				int nextCharAsciiValue;
				if(i != c.length-1)
					nextCharAsciiValue = c[i+1];
				else
					nextCharAsciiValue = ' ';
				if(nextCharAsciiValue != asciiValue + 1)
				{
					LastElement = Character.toString(c[i]);
					i++;
					break;
				}
				else
					count++;			
				i++;
			}
			if(count ==0)
				newStr = newStr + firstElement;
			else
				newStr = newStr + firstElement + "-" + LastElement;
		}
		System.out.println(newStr);
		*/
		swap();
		
	}
	
	
	/*static int minimumSwaps() {
		int[] arr = {7,1,3,2,4,5,6};
		int[] newArr = new int[arr.length];
		int swapCount = 0;
        for(int i = arr.length-1; i >0;i--)
        {
        		int swapIndex = -1;
            for(int j = i-1; j>0; j--)
            {
                if(arr[i]<arr[j])
                    swapIndex = j;
            }
        }
        return swapCount;
    }*/
	
	static int minimumSwaps() {
		int[] a = {7,1,3,2,4,5,6};
        int swap=0;
        for(int i=0;i<a.length;i++){
            if(i+1!=a[i]){
                int t=i;
                while(a[t]!=i+1){
                    t++;  
                }
                int temp=a[t];
                a[t]=a[i];
                a[i]=temp;
                swap++;
            }
        }
        return swap;

    }
	
	
	static void swap()
	{
		int arr[] = {7,1,3,2,4,5,6};
		int swap = 0;
		for(int i = 0 ; i < arr.length; i++)
		{
			if(arr[i] != i+1)
			{
				int t = i;
				while(arr[t]!= i+1)
				{
					t++;
				}
				int temp = arr[t];
				arr[t] = arr[i];
				arr[i] = temp;
				swap++;
			}
		}
		System.out.println(swap);
	}
	
	
	
	
	

	

}
