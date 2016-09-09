import java.math.BigInteger;
import java.util.ArrayList;


public class Problem271ModularCubes1 {
	static class PrimePower {
		public int p;
		public int exp;
		public PrimePower(int p, int exp)
		{
			this.p = p;
			this.exp = exp;
		}
		public long value()
		{
			return (long) Math.pow(p, exp);
		}
		public long phi()
		{
			return ((long) Math.pow(p, exp - 1))*(p - 1);
		}
	}
	public static long fastExp(long base, long exp, long mod)
	{
		String s = Long.toBinaryString(exp);
		long output = base;
		for(int i = 1; i < s.length(); i++)
		{
			output = (output*output)%mod;
			if(s.charAt(i) == '1')
				output = (output*base)%mod;
		}
		return output;
	}
	public static void main(String[] args) {
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(10000);
		//long input = 91;
		long input = 13082761331670030L;
		ArrayList<PrimePower> primeFactorization = new ArrayList<PrimePower>();
		long a = input;
		int primeCounter = 0;
		int expCounter = 0;
		while(a > 1)
		{
			int p = primes.get(primeCounter);
			while(a % p == 0)
			{
				expCounter++;
				a /= p;
			}
			primeFactorization.add(new PrimePower(p, expCounter));
			expCounter = 0;
			primeCounter++;
		}
		ArrayList<Long> solutions = new ArrayList<Long>();
		solutions.add(1L);
		long product = 1;
		for(int i = 0; i < primeFactorization.size(); i++)
		{
			PrimePower pp = primeFactorization.get(i);
			//int p = pp.p;
			//int exp = pp.exp;
			ArrayList<Long> newSolutions = new ArrayList<Long>();
			long phi = pp.phi();
			if(phi%3 != 0)
			{
				BigInteger bProduct = new BigInteger(product + "");
				BigInteger bValue = new BigInteger(pp.value() + "");
				//System.out.println(bProduct + " " + bValue);
				for(int j = 0; j < solutions.size(); j++)
				{
					BigInteger bGet = new BigInteger(solutions.get(j) + "");
					long z = MethodEuclideanAlgorithm.chineseRemainderTheorem(bGet, bProduct, BigInteger.ONE, bValue).longValue();
					newSolutions.add(z);
					//System.out.println(solutions.get(j) + " " + product + " " + solution + " " + pp.value() + " " + x);
					//System.out.println(solutions.get(j) + " " + product + " " + solution1 + " " + pp.value() + " " + y);
				}
			}
			else
			{
				long base = 1;
				long solution = 1;
				while(solution == 1)
				{
					base++;
					solution = fastExp(base, phi/3, pp.value());
				}
				long solution1 = new BigInteger(solution + "").pow(2).mod(new BigInteger(pp.value() + "")).longValue();
				//System.out.println(solution + " " + solution1 + " " + pp.value());
				BigInteger bProduct = new BigInteger(product + "");
				BigInteger bSolution = new BigInteger(solution + "");
				BigInteger bSolution1 = new BigInteger(solution1 + "");
				BigInteger bValue = new BigInteger(pp.value() + "");
				//System.out.println(bProduct + " " + bValue);
				for(int j = 0; j < solutions.size(); j++)
				{
					BigInteger bGet = new BigInteger(solutions.get(j) + "");
					long x = MethodEuclideanAlgorithm.chineseRemainderTheorem(bGet, bProduct, bSolution, bValue).longValue();
					newSolutions.add(x);
					long y = MethodEuclideanAlgorithm.chineseRemainderTheorem(bGet, bProduct, bSolution1, bValue).longValue();
					newSolutions.add(y);
					long z = MethodEuclideanAlgorithm.chineseRemainderTheorem(bGet, bProduct, BigInteger.ONE, bValue).longValue();
					newSolutions.add(z);
					//System.out.println(solutions.get(j) + " " + product + " " + solution + " " + pp.value() + " " + x);
					//System.out.println(solutions.get(j) + " " + product + " " + solution1 + " " + pp.value() + " " + y);
				}
			}
			solutions = newSolutions;
			product *= pp.value();
			//System.out.println(product);
			System.out.println(solutions);
		}
		BigInteger sum = BigInteger.ZERO;
		int badCount = 0;
		for(Long l : solutions)
		{
			BigInteger bl = new BigInteger(l + "");
			if(!bl.modPow(new BigInteger(3 + ""), new BigInteger(input + "")).equals(BigInteger.ONE))
			{
				badCount++;
				//System.out.println(l);
			}
			sum = sum.add(new BigInteger(l + ""));
		}
		System.out.println(badCount);
		//System.out.println(solutions.size());
		//System.out.println(solutions);
		System.out.println(sum.subtract(BigInteger.ONE));
	}

}
