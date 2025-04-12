import java.util.Arrays;
import java.util.Random;

 class SortingComparison {

    // Bubble Sort (O(N²)) - Inefficient for large datasets
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N)) - Stable sorting
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(arr, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
        while (i <= mid - left && j < temp.length) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid - left) arr[k++] = temp[i++];
        while (j < temp.length) arr[k++] = temp[j++];
    }

    // Quick Sort (O(N log N)) - Partition-based approach
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[right]; arr[right] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 10000; // Adjust dataset size for testing
        int[] dataset = new int[N];

        // Generate random dataset
        for (int i = 0; i < N; i++) {
            dataset[i] = random.nextInt(N);
        }

        // Copy arrays for independent sorting
        int[] bubbleDataset = Arrays.copyOf(dataset, N);
        int[] mergeDataset = Arrays.copyOf(dataset, N);
        int[] quickDataset = Arrays.copyOf(dataset, N);

        // Measure Bubble Sort time
        long start = System.nanoTime();
        bubbleSort(bubbleDataset);
        long bubbleTime = System.nanoTime() - start;

        // Measure Merge Sort time
        start = System.nanoTime();
        mergeSort(mergeDataset, 0, N - 1);
        long mergeTime = System.nanoTime() - start;

        // Measure Quick Sort time
        start = System.nanoTime();
        quickSort(quickDataset, 0, N - 1);
        long quickTime = System.nanoTime() - start;

        // Print results
        System.out.println("Dataset Size: " + N);
        System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");
        System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");
        System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");
    }
}
