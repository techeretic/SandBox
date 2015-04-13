import java.util.*;

public class AnagramCheck {
	
	public static String [] arr = {
		"trees", "bike", "cars", "steer", "arcs"
	};
	
	public static void main(String[] args) {
		HashSet<Integer> processedNode = new HashSet<>();
		int i = 0, j = 1;
		System.out.println("Array Length = " + arr.length);
		while(i < arr.length-1) {
			if (processedNode.contains(i)) {
				i++;
				j = i+1;
				if (i >= arr.length-1)
					break;
			}
			System.out.println("\n i = " + i + " j = " + j);
			if (isAnagram(arr[i], arr[j])) {
				processedNode.add(i);
				processedNode.add(j);
				System.out.println("Pair : " + arr[i] + ":" + arr[j]);
				j=++i + 1;
			} else {
				if (j == arr.length-1) {
					processedNode.add(i);
					System.out.println("Single : " + arr[i]);
					j = ++i + 1;
				} else {
					j++;
				}
			}
		}
		
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
			return false;
		}
		HashSet<Character> s1_chars = new HashSet<>();
		for(char ch : s1.toCharArray()) {
			s1_chars.add(ch);
		}
		for(char ch : s2.toCharArray()) {
			if (!s1_chars.contains(ch)) {
				return false;
			}
		}
		return true;
	}
}
