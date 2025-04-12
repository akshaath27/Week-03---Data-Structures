import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Specify the file path

        try {
            // Create a FileReader and wrap it with BufferedReader for efficient reading
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) { // Read each line until EOF
                System.out.println(line);
            }

            // Close resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
