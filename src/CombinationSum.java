import java.util.ArrayList;
import java.util.List;

/**
 * Created by pshetye on 7/9/17.
 */
public class CombinationSum {

    public static void main(String [] args) {
        List<List<Integer>> res = combinationSum(new int[]{5, 1, 2, 3, 4, 7}, 7);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        getCombos(results, new ArrayList<Integer>(), target, 0, candidates);
        return results;
    }

    private static void getCombos(List<List<Integer>> results, List<Integer> current, int remainder, int index, int[] candidates) {
        if (remainder < 0) {
            return;
        }
        if (remainder == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i<candidates.length; i++) {
            current.add(candidates[i]);
            getCombos(results, current, remainder - candidates[i], i, candidates);
            current.remove(current.size() - 1);
        }
    }
}
