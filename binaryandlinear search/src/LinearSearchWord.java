public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is a popular programming language.",
                "Linear search is a simple searching algorithm.",
                "Machine learning is revolutionizing technology.",
                "Data structures are important for programming."
        };

        String targetWord = "search";

        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Sentence containing '" + targetWord + "': " + result);
    }
}
