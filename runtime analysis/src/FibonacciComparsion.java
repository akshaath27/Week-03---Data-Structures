 class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int N = 30;

        long start = System.nanoTime();
        int recursiveResult = fibonacciRecursive(N);
        long recursiveTime = System.nanoTime() - start;

        start = System.nanoTime();
        int iterativeResult = fibonacciIterative(N);
        long iterativeTime = System.nanoTime() - start;

        System.out.println("Fibonacci Number (N=" + N + "):");
        System.out.println("Recursive Result: " + recursiveResult + ", Time: " + (recursiveTime / 1_000_000.0) + " ms");
        System.out.println("Iterative Result: " + iterativeResult + ", Time: " + (iterativeTime / 1_000_000.0) + " ms");
    }
}
