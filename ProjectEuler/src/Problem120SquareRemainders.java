
public class Problem120SquareRemainders {
	public static void main(String[] args) {
		long sum = 0;
		for(int a = 3; a <= 1000; a++)
		{
			if(a%2 == 0)
				sum += (a-2)*a;
			else
				sum += (a-1)*a;
		}
		System.out.println(sum);
	}

}
