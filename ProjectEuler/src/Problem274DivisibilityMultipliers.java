import java.util.ArrayList;


public class Problem274DivisibilityMultipliers {
	public static void main(String[] args) {
		//divisibility multiplier of p is inverse of 10 mod p
		int bound = 10000000;
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(bound);
		long sum = 1; //p = 3
		for(int i = 3; i < primes.size(); i++)
			sum += (MethodEuclideanAlgorithm.extendedEuclideanAlgorithm(10, primes.get(i))[1] + primes.get(i))%primes.get(i);
		System.out.println(sum);
	}

}
