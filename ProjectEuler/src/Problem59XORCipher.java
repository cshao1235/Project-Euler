import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Problem59XORCipher {
	public static String xorCipher(ArrayList<Integer> ciphertext, String key)
	{
		StringBuffer s = new StringBuffer("");
		for(int i = 0; i < ciphertext.size(); i++)
			s.append(((char) (ciphertext.get(i) ^ key.charAt(i%key.length()))));
		return s.toString();
	}
	public static void main(String[] args)
	{
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("Problem59.txt"));
			StringTokenizer st = new StringTokenizer(f.readLine(), ",");
			ArrayList<Integer> ciphertext = new ArrayList<Integer>();
			while(st.hasMoreTokens())
				ciphertext.add(Integer.parseInt(st.nextToken()));
			//System.out.println(ciphertext);
			FileWriter fout = new FileWriter("Problem59Output.txt");
			for(int i = 0; i < 26; i++)
			{
				for(int j = 0; j < 26; j++)
				{
					for(int k = 0; k < 26; k++)
					{
						String key = "" + (char) (i + 'a') + (char) (j + 'a') + (char) (k + 'a');
						String decoded = xorCipher(ciphertext, key);
						fout.write(decoded + "\n");
					}
				}
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
