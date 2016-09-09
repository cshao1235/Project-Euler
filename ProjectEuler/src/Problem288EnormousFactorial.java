
public class Problem288EnormousFactorial {
	public static long nf(int p, int q, int k) //nf(p, q) mod p^k
	{
		long[] powersOfP = new long[k + 1];
		powersOfP[0] = 1;
		for(int i = 1; i <= k; i++)
			powersOfP[i] = p*powersOfP[i-1];
		long mod = powersOfP[k];
		//System.out.println(mod);
		long[] s = new long[q+1];
		s[0] = 290797;
		for(int i = 1; i <= q; i++)
			s[i] = (s[i-1]*s[i-1])%50515093;
		int[] t = new int[q + 1];
		for(int i = 0; i <= q; i++)
			t[i] = (int) s[i]%p;
		
		long sum = 0;
		long output = 0;
		for(int i = k; i <= q; i++)
			sum += t[i];
		for(int i = k - 1; i >= 0; i--)
		{
			//long output1 = output;
			//for(int j = 0; j < p; j++)
			//	output = (output + output1)%mod;
			/*output = (output*p)%mod;
			output = (output + sum)%mod;
			if(output < 0)
				System.out.println(output);*/
			long coefficient = sum%powersOfP[k - i];
			output = (output + coefficient*powersOfP[i])%mod;
			sum += t[i];
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(nf(3, 10000, 20));
		System.out.println(nf(61, 10000000, 10));
	}

}
