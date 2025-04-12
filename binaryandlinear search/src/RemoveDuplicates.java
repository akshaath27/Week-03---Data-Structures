import java.util.HashSet;

class RemoveDuplicates {
    public static String removeDuplicateChars(String str) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello world";
        String output = removeDuplicateChars(input);
        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + output);
    }
}
