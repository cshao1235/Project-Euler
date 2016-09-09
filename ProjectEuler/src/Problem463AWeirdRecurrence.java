
public class Problem463AWeirdRecurrence {
	public static long computeF(long l) //f(l) is the number obtained when reading the binary representation of l from right to left.
	{
		String s = Long.toBinaryString(l);
		StringBuffer s1 = new StringBuffer("");
		for(int i = s.length() - 1; i>=0; i--)
			s1.append(s.charAt(i));
		return Long.parseLong(s1.toString(), 2);
	}
	public static void main(String[] args) {
		long n = 8;
		long sum = 0;
		for(long i = 1; i <= n; i++)
			sum += computeF(i);
		System.out.println(sum);
	}

}
