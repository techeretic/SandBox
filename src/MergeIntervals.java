import java.util.*;

/**
 * Created by pshetye on 7/13/16.
 */
public class MergeIntervals {
    private static class Interval {
        public int start = 0;
        public int end = 0;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String [] args) throws Exception {
        List<Interval> ip = new ArrayList<Interval>() {
            {
                add(new Interval(8, 10));
                add(new Interval(2, 6));
                add(new Interval(15, 18));
                add(new Interval(1, 3));
            }
        };
        System.out.println(Arrays.toString(ip.toArray()));
        System.out.println(Arrays.toString(merge(ip).toArray()));
        List<Interval> ip2 = new ArrayList<Interval>() {
            {
                add(new Interval(8, 15));
                add(new Interval(1, 4));
                add(new Interval(15, 18));
                add(new Interval(2, 3));
            }
        };
        System.out.println(Arrays.toString(ip2.toArray()));
        System.out.println(Arrays.toString(merge(ip2).toArray()));
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }
        List<Interval> results = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        System.out.println("\nAfter sort" + Arrays.toString(intervals.toArray()));
        Interval prev = null;
        for (Interval i : intervals) {
            if (results.isEmpty()) {
                prev = i;
                results.add(prev);
                continue;
            }

            if (prev == null) {
                break;
            }

            if (prev.end > i.end) {
                continue;
            }

            if (prev.end >= i.start && prev.end < i.end) {
                prev.end = i.end;
            }

            if (prev.end < i.start) {
                prev = i;
                results.add(prev);
            }
        }

        return results;
    }
}
