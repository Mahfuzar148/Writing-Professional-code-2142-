import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Specify the path to the output file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, ");
            writer.write("BufferedWriter!");
            writer.newLine(); // Move to the next line
            writer.write("This is a new line.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
