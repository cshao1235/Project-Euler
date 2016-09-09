
public class Problem21AmicableNumbers {
	public static int sumOfProperDivisors(int n)
	{
		int sum = 1;
		for(int i = 2; i <= Math.sqrt(n); i++)
		{
			if(n%i == 0)
				sum += i + n/i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int n = 10000;
		int[] divisors = new int[10*n];
		for(int i = 2; i < n; i++)
			divisors[i] = sumOfProperDivisors(i);
		long sum = 0;
		for(int i = 2; i < n; i++)
		{
			if(divisors[i] != i && divisors[divisors[i]] == i)
			{
				System.out.println(i + " " + divisors[i]);
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
