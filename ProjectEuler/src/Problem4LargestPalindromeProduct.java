public class Problem4LargestPalindromeProduct {
	public static boolean isPalindrome(String s)
	{
		for(int i = 0; i < s.length()/2; i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int lower = 100;
		int upper = 999;
		int max = 0;
		for(int i = lower; i <= upper; i++)
		{
			for(int j = i; j <= upper; j++)
			{
				int product = i*j;
				String s = product + "";
				if(isPalindrome(s) && product > max)
					max = product;
			}
		}
		System.out.println(max);
	}

}
