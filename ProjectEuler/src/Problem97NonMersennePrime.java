
public class Problem97NonMersennePrime {
	public static long lastNDigits(int n, long coefficient, int power) //last n digits of coefficient * 2^power + 1, n < power
	{
		long power2 = (long) Math.pow(2, n);
		long r2 = 1; //residue mod 2^n
		long power5 = (long) Math.pow(5, n);
		//System.out.println(power5);
		long newPower = (long) (power%(4*power5/5));
		//System.out.println(newPower);
		long new2Power = 1;
		for(int i = 1; i <= newPower; i++)
			new2Power = 2*new2Power % power5;
		long r5 = ((coefficient % power5)*(new2Power) + 1) % power5;
		//System.out.println(r5);
		while(r5%power2 != r2)
			r5 += power5;
		return r5;
	}
	public static void main(String[] args) {
		System.out.println(lastNDigits(10, 28433, 7830457));
	}

}
