import java.io.*;
import java.util.Scanner;

public class WordCountExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file name from user
        System.out.print("Enter file name: ");
        String filePath = scanner.nextLine();

        // Get target word from user
        System.out.print("Enter word to count: ");
        String targetWord = scanner.nextLine();

        int count = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        scanner.close();
    }
}
