import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Problem99LargestExponential {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("Problem99.txt"));
			double maxLog = 0;
			int maxLineNumber = -1;
			for(int i = 1; i <= 1000; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine(), ",");
				int base = Integer.parseInt(st.nextToken());
				int exp = Integer.parseInt(st.nextToken());
				double newLog = Math.log(base) * exp;
				if(newLog > maxLog)
				{
					maxLog = newLog;
					maxLineNumber = i;
				}
			}
			System.out.println(maxLineNumber);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
