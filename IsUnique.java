public class IsUnique {
	public static void main(String[] args) {
		final String input = "Andorg";
		System.out.printf("%s == %s", input, isUniq(input));
	}

	private static boolean isUniq(String test) {
		boolean uniq = true;
		int i = 0;
		while (uniq && i < test.length() - 1) {
			uniq = test.substring(i + 1).indexOf(test.charAt(i)) == -1;
			i++;
		}
		return uniq;
	}
}

