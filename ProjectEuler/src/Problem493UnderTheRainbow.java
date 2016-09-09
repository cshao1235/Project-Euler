
public class Problem493UnderTheRainbow {
	public static void main(String[] args) {
		//expected value is 7*(1 - (60C20)/(70C20))
		double p = 1.0;
		for(int i = 1; i <= 10; i++)
			p *= (40.0 + i)/(60.0 + i);
		p = 1 - p;
		p *= 7;
		System.out.println(p);
	}

}
