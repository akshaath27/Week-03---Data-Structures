import java.io.*;

public class ConsoleToFileExample {
    public static void main(String[] args) {
        String filePath = "output.txt";

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filePath, true);  // Append mode

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(userInput + "\n"); // Write input to file with a new line
            }

            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();

            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
