import java.util.HashMap;

public class Problem7Prime10001 
{
	public static int nthPrime(int n)
	{
		if(n == 1)
			return 2;
		else if(n == 2)
			return 3;
		else
		{
			int primeCount = 2;
			boolean[] isPrime = new boolean[96*n+2];
			isPrime[2] = true;
			isPrime[3] = true;
			int prime = 0;
			for(int i = 1; i <= 16*n; i++)
			{
				int a = 6*i - 1;
				boolean isAPrime = true;
				for(int k = 2; k <= Math.sqrt(a); k++)
				{
					if(isPrime[k] && a%k == 0)
					{
						isAPrime = false;
						break;
					}
				}
				isPrime[a] = isAPrime;
				if(isAPrime)
					primeCount++;
				if(primeCount == n)
				{
					prime = a;
					break;
				}
				int b = 6*i + 1;
				boolean isBPrime = true;
				for(int k = 2; k <= Math.sqrt(b); k++)
				{
					if(isPrime[k] && b%k == 0)
					{
						isBPrime = false;
						break;
					}
				}
				isPrime[b] = isBPrime;
				if(isBPrime)
					primeCount++;
				if(primeCount == n)
				{
					prime = b;
					break;
				}
			}
			return prime;
		}
	}
	public static void main(String[] args)
	{
		for(int i = 1; i < 20; i++)
			System.out.println(nthPrime(i));
		System.out.println(nthPrime(10001));
		//HashMap<String, Integer> h = new HashMap<String, Integer>();
		//h.put("a", 1);
		//System.out.println(1 + h.get("b"));
	}

}