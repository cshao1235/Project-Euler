
public class Problem131PrimeCubePartnership {
	public static boolean isPrime(int n)
	{
		if(n == 1)
			return false;
		if(n == 2)
			return true;
		for(int i = 3; i <= Math.sqrt(n); i+=2)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int x = 1;
		int max = 100;
		int count = 0;
		while(3*x*x + 3*x + 1 < max)
		{
			if(isPrime(3*x*x + 3*x + 1))
				count++;
			x++;
		}
		System.out.println(count);
	}

}
