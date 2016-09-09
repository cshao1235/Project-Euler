
public class Problem66PellEquation {
	public static void main(String[] args) {
		int d = 1000;
		int max = 0;
		for(int i = 2; i <= d; i++)
		{
			int sqrt = (int) Math.sqrt(i);
			if(sqrt * sqrt == i)
				continue;
			else
			{
				double a = Math.sqrt(i);
				int x = sqrt;
				a -= x;
				int y = (int) (1.0/a + 1);
				a = y - 1.0/a;
				while((x*y-1)*(x*y-1) - i*y*y != 1)
				{
				}
			}
		}
	}

}
