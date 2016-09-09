import java.util.Arrays;


public class Problem250Set250250 {
	private static final long MOD = 10000000000000000L;
	public static void main(String[] args) {
		/*int[] residues = new int[500];
		for(int i = 0; i < 500; i++)
		{
			if(i%250 == 0)
				residues[i] = 0;
			else
			{
				int base = i%250;
				int exp = i%100;
				int value = 1;
				for(int j = 0; j < exp; j++)
					value = (value*base)%250;
				residues[i] = value;
			}
		}
		System.out.println(Arrays.toString(residues));*/
		long[][] numSubsets = new long[250][2];
		int size = 250250;
		int count = 0;
		numSubsets[0][0] = 1;
		while(count < size)
		{
			count++;
			int residue = count%250;
			int exp = residue;
			String s = Integer.toBinaryString(count);
			//if(count < 250)
			//	System.out.println(s);
			for(int i = 1; i < s.length(); i++)
			{
				exp = (exp * exp)%250;
				if(s.charAt(i) == '1')
					exp = (exp * residue)%250;
			}
			//if(count < 250)
			//	System.out.println(exp);
			for(int i = 0; i < 250; i++)
				numSubsets[(i + exp)%250][count % 2] = (numSubsets[(i + exp)%250][(count - 1) % 2] + numSubsets[i][(count - 1) % 2])%MOD;
			//numSubsets[residues[count%500]][count % 2] = (numSubsets[residues[count%500]][count % 2])%MOD;
		}
		//for(int i = 0; i < 250; i++)
		//	System.out.print(numSubsets[i][0] + " ");
		System.out.println();
		System.out.println(numSubsets[0][size % 2] - 1);
	}

}
