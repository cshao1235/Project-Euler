import java.util.Arrays;


public class Problem25FibonacciWith1000Digits
{
	private static final int BASE = 10;
	public static int[] addArrays(int[] a, int[] b)
	{
		int[] sum = new int[a.length];
		for(int i = a.length - 1; i >= 1; i--)
		{
			if(a[i] == 0 && b[i] == 0 && sum[i] == 0)
				break;
			sum[i-1] = (sum[i] + a[i] + b[i])/BASE;
			sum[i] = (sum[i] + a[i] + b[i])%BASE;
		}
		if(sum[0] != 0)
			return new int[a.length];
		return sum;
	}
	public static boolean isZero(int[] a)
	{
		for(int i = a.length - 1; i >= 0; i--)
		{
			if(a[i] != 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		//int[][] fibonacci = new int[10000][1000];
		//fibonacci[0][999] = 1;
		//fibonacci[1][999] = 1;
		//for(int i = 2; i < 10000; i++)
		//{
		//	fibonacci[i] = addArrays(fibonacci[i-2], fibonacci[i-1]);
		//	System.out.println(i + ": " + Arrays.toString(fibonacci[i]));
		//}
		/*int[] fibonacci2 = new int[1000];
		int[] fibonacci1 = new int[1000];
		fibonacci2[999] = 1;
		fibonacci1[999] = 1;
		int[] fibonacci = addArrays(fibonacci1, fibonacci2);
		int n = 2;
		//System.out.println(Arrays.toString(fibonacci));
		while(!isZero(fibonacci))
		{
			fibonacci2 = fibonacci1;
			fibonacci1 = fibonacci;
			fibonacci = addArrays(fibonacci2, fibonacci1);
			n++;
			if(n >= 4780 && n <= 4790)
				System.out.println(Arrays.toString(fibonacci));
		}
		System.out.println(n);*/
		double numDigits = 1000;
		int n1 = (int) ((numDigits - 1 + 1/2 * Math.log10(5))/Math.log10((1 + Math.sqrt(5))/2));
		System.out.println(n1);
	}
}
