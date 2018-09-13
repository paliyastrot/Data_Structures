import java.util.Arrays;
import java.util.Scanner;


//only for string of lower case alphabets
public class Rabin_Karp 
{
	String text ;
	String pattern ;
	
	public Rabin_Karp(String text, String pattern)
	{
		this.pattern = pattern;
		this.text = text;
	}
	
	
	//rolling hash function
	public long[] hashFunction()
	{
		long hashArray[] = new long[text.length()-pattern.length()+1];
		int hashvalue = 0;
		int x =0;
		for(int i=0;i<text.length();i++)
		{
			if(i>=pattern.length())
			{
				hashArray[x++] = hashvalue;
	
				hashvalue = (hashvalue-(text.charAt(i-pattern.length())-'a'+1)*(int)Math.pow(26, pattern.length()-1))*26;//extracting last two numbers from the previous hashvalue
	
						hashvalue = hashvalue+ (text.charAt(i)-'a'+1);
	
			}
			else
			{
				hashvalue = hashvalue+(text.charAt(i)-'a'+1)*(int)Math.pow(26, pattern.length()-1-i);//calculating hash value for first time
			}
		}
		hashArray[x]=hashvalue;
		System.out.println(Arrays.toString(hashArray));
		return hashArray;
	}
	
	
	//hash function for calculating hash value for pattern string
	public long hashPattern()
	{
		long hashValue = 0;
		for(int i=0;i<pattern.length();i++)
			hashValue = hashValue+(pattern.charAt(i)-'a'+1)*(int)Math.pow(26, pattern.length()-1-i);
		System.out.println(hashValue);
		return hashValue;
	}
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		String text= scan.next();
		String pattern = scan.next();
		Rabin_Karp test = new Rabin_Karp(text, pattern);
		long[] hashtext = test.hashFunction();
		long hashpattern = test.hashPattern();
		scan.close();
		for(int i=0;i<hashtext.length;i++)
		{
			if(hashpattern==hashtext[i])
			{
				System.out.println("Pattern Found");
				return ;
			}
		}
		System.out.println("Pattern Not Found");
		
		
	}

}
