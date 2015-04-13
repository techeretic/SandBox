
public class Palindrome {

	public static void main(String[] args) {
		String str = "A man, A plan, a canal -- Panama!";
		System.out.println(str + " is " 
				+ (isPalindrome(str) ? "Palindrome" : "NOT a Palindrome"));
	}

	public static boolean isPalindrome(String str) {
		int i=0, j=str.length()-1;
		while(i<j) {
			if (!Character.isLetter(str.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetter(str.charAt(j))) {
				j--;
				continue;
			}
			System.out.println(Character.toLowerCase(str.charAt(i)) + " & "
					+ Character.toLowerCase(str.charAt(j)));
			if (Character.toLowerCase(str.charAt(i)) != 
					Character.toLowerCase(str.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
}
