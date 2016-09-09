
public class Problem28NumberSpiralDiagonals {
	public static void main(String[] args) {
		int n = 1001;
		long sum = 1;
		for(int i = 3; i <= n; i+=2)
			sum += 4*(i*i - 3*(i-1)/2);
		System.out.println(sum);
	}

}
