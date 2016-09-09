
public class Problem2EvenFibonacci {
	public static void main(String[] args) {
		int fibonacci2 = 1;
		int fibonacci1 = 1;
		int fibonacci = fibonacci2 + fibonacci1;
		int sum = 0;
		while(fibonacci <= 4000000)
		{
			if(fibonacci%2 == 0)
				sum+=fibonacci;
			fibonacci2 = fibonacci1;
			fibonacci1 = fibonacci;
			fibonacci = fibonacci2 + fibonacci1;
		}
		System.out.println(sum);
	}

}
