
public class SumOfSquares {

	public static void main(String[] args) {
		int sum = 50;
		System.out.println("Possibilities for " + sum + " are : "
				+ getPossibilities(sum));
	}

	public static int getPossibilities(int sum) {
		int start = (int) Math.sqrt(sum);
		int count = 0;
		int hop = 0;
		double val = 0.0;
		while(start > (int) val) {
			hop++;
			val = Math.sqrt(sum - Math.pow(start, 2));
			if (val % 1 == 0) {
				System.out.println(sum + "=" + start + "^2 + " + (int) val + "^2");
				count++;
			}
			start--;
		}
		System.out.println("Completed " + hop + " hops");
		return count;
	}
}
