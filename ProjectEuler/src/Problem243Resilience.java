import java.util.ArrayList;


public class Problem243Resilience {
	public static void main(String[] args)
	{
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(100);
		int n = 15499;
		int d = 94744;
		long lhs = d;
		long rhs = n * 2;
		int i;
		for(i = 1; i < primes.size(); i++)
		{
			if(lhs >= rhs)
			{
				lhs *= primes.get(i) - 1;
				rhs *= primes.get(i);
			}
			else
				break;
		}
		//System.out.println(lhs);
		//System.out.println(rhs);
		lhs /= d;
		rhs /= n;
		//System.out.println(lhs);
		//System.out.println(rhs);
		long lhs1 = lhs;
		long rhs1 = rhs;
		while((double) lhs / (rhs - 1) >= (double) n/d)
		{
			lhs += lhs1;
			rhs += rhs1;
		}
		System.out.println(rhs);
	}
}
