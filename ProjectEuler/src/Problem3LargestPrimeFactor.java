import java.util.ArrayList;
import java.util.HashSet;


public class Problem3LargestPrimeFactor {
	public static ArrayList<Integer> primeFactors(long n)
	{
		//long n = 600851475143L;
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes((int) Math.sqrt(n));
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for(int i : primes)
		{
			while(n%i == 0)
			{
				n/=i;
				primeFactors.add(i);
			}
			if(n == 1)
				break;
		}
		return primeFactors;
		//System.out.println(primeFactors.toString());
	}
	public static void main(String[] args) {
		System.out.println(primeFactors(25).toString());
	}
}
