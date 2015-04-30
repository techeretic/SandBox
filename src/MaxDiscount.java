import java.util.*;


public class MaxDiscount {

	public static void main(String[] args) {
		MaxDiscount md = new MaxDiscount();
		List<Discount> dis = new ArrayList<Discount>(Arrays.asList(
				md.new Discount(1, 5, 10),
				md.new Discount(2, 8, 5),
				md.new Discount(4, 6, 20)
			));
		md.getBestPeriod(dis);
	}
	
	public Discount getBestPeriod(List<Discount> dis) {
		Discount result = new Discount(0, 0, 0);
		for (Discount d : dis) {
			if (result.getDiscount() == 0) {
				result = d;
			} else {
				if (d.getStart() < result.getStart() ||
						d.getEnd() > result.getEnd()) {
					result.setStart(Math.max(result.getStart(), d.getStart()));
					result.setEnd(Math.min(result.getEnd(), d.getEnd()));
					result.setDiscount(result.getDiscount()+d.getDiscount());
				} else if (result.getDiscount() < d.getDiscount()) {
					result = d;
				}
			}
			System.out.println(result);
		}
		return result;
	}

	public class Discount {
		int start;
		int end;
		int discount;
		
		Discount(int st, int en, int dis) {
			start = st;
			end = en;
			discount = dis;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getDiscount() {
			return discount;
		}

		public void setDiscount(int discount) {
			this.discount = discount;
		}
		
		@Override
		public String toString() {
			return "From " + start + " to " + end + " with discount = " + discount;
		}
	}
}
