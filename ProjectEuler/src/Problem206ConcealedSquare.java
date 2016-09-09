
public class Problem206ConcealedSquare {
	public static long result = 0;
	public static void search(int level, long n)
	{
		if(level == 9)
		{
			long x = (long) Math.sqrt(n);
			if(x*x == n)
				result = x;
		}
		else
		{
			if(result != 0)
				return;
			else
			{
				for(int i = 0; i < 10; i++)
				{
					long a = n;
					a = 100*a + 10*i + ((level + 1) % 10);
					search(level + 1, a);
				}
			}
		}
	}
	public static void main(String[] args) {
		search(1, 1);
		System.out.println(result*10);

	}

}
