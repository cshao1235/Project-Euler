
public class Problem9SpecialPythagoreanTriple {
	public static void main(String[] args) {
		int k = 25;
		int m = 4;
		int n = 1;
		int a = k*(m*m - n*n);
		int b = 2*k*m*n;
		int c = k*(m*m + n*n);
		System.out.println(a + " " + b + " " + c + " " + a*b*c);
	}

}
