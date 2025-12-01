import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notebook {

    File file = new File("notebook.txt");

    public void writeToFile(String text) throws IOException {
        // If the file does not exist, create it
        if (!file.exists()) {
            file.createNewFile();
        }

        // Append the text exactly as received (NO extra newline)
        FileWriter writer = new FileWriter(file, true); // append = true
        writer.write(text);
        writer.close();
    }

    public String readFromFile() throws IOException {
        // If file does not exist, return null
        if (!file.exists()) {
            return null;
        }

        // Read entire content exactly as stored
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z"); // end of input

        String content;
        if (scanner.hasNext()) {
            content = scanner.next(); // whole file as one String
        } else {
            content = ""; // empty file
        }

        scanner.close();
        return content;
    }

    public boolean deleteFile() {
        // If file exists, delete it and return the result
        if (file.exists()) {
            return file.delete();
        }
        return false; // file did not exist
    }

}
