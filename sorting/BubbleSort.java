import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter the marks of the students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }


        bubbleSort(marks);


        System.out.println("Sorted marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;


        for (int i = 0; i < n - 1; i++) {
            swapped = false;


            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }


            if (!swapped) {
                break;
            }
        }
    }
}
