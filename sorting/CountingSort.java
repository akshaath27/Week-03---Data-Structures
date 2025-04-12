import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the ages (10-18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        countingSort(ages);
        System.out.println("Sorted ages in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }

    public static void countingSort(int[] arr) {
        int min = 10;
        int max = 18;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int age : arr) {
            count[age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
