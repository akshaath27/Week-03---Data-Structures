import java.io.*;

class FileReadingComparison {

    public static void main(String[] args) {
        File file = new File("largefile.txt"); // Replace with actual large file path

        try {
            // Measure performance of FileReader
            long start = System.nanoTime();
            readUsingFileReader(file);
            long fileReaderTime = System.nanoTime() - start;

            // Measure performance of InputStreamReader
            start = System.nanoTime();
            readUsingInputStreamReader(file);
            long inputStreamReaderTime = System.nanoTime() - start;

            // Print results
            System.out.println("File Size: " + (file.length() / (1024 * 1024)) + " MB");
            System.out.println("FileReader Time: " + (fileReaderTime / 1_000_000.0) + " ms");
            System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1_000_000.0) + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to read file using FileReader (Character Stream)
    public static void readUsingFileReader(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            int charData;
            while ((charData = fileReader.read()) != -1) {
                // Simulate processing (e.g., character output)
            }
        }
    }

    // Method to read file using InputStreamReader (Byte Stream)
    public static void readUsingInputStreamReader(File file) throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file))) {
            int charData;
            while ((charData = inputStreamReader.read()) != -1) {
                // Simulate processing (e.g., character output)
            }
        }
    }
}
