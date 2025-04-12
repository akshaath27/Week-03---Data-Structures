 class StringConcatenationComparison {

    public static void main(String[] args) {
        int N = 1_000_000; // Number of concatenations

        // Measure performance of String
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Inefficient, creates new object each time
        }
        long stringTime = System.nanoTime() - start;

        // Measure performance of StringBuilder
        start = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringBuilder.append("a"); // Fast, mutable, thread-unsafe
        }
        long stringBuilderTime = System.nanoTime() - start;

        // Measure performance of StringBuffer
        start = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            stringBuffer.append("a"); // Thread-safe, slightly slower than StringBuilder
        }
        long stringBufferTime = System.nanoTime() - start;

        // Print results
        System.out.println("Concatenation Count: " + N);
        System.out.println("String Time: " + (stringTime / 1_000_000.0) + " ms");
        System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000.0) + " ms");
        System.out.println("StringBuffer Time: " + (stringBufferTime / 1_000_000.0) + " ms");
    }
}
