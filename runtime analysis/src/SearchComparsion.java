import java.util.Arrays;
import java.util.Random;
public class SearchComparsion {
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 1000000; // Change dataset size as needed
        int[] dataset = new int[N];

        // Fill dataset with random numbers
        for (int i = 0; i < N; i++) {
            dataset[i] = random.nextInt(N);
        }

        int target = dataset[random.nextInt(N)]; // Randomly pick a target

        // Measure Linear Search Time
        long start = System.nanoTime();
        boolean linearResult = linearSearch(dataset, target);
        long linearTime = System.nanoTime() - start;

        // Sort the dataset for Binary Search
        Arrays.sort(dataset);

        // Measure Binary Search Time
        start = System.nanoTime();
        boolean binaryResult = binarySearch(dataset, target);
        long binaryTime = System.nanoTime() - start;

        // Print Results
        System.out.println("Target: " + target);
        System.out.println("Linear Search Time: " + (linearTime / 1_000_000.0) + " ms, Found: " + linearResult);
        System.out.println("Binary Search Time: " + (binaryTime / 1_000_000.0) + " ms, Found: " + binaryResult);
    }
}
