import java.io.*;

public class Notebook {

    private final String fileName = "notebook.txt";

    // Write text to file (append mode)
    public void writeToFile(String text) throws IOException {
        File file = new File(fileName);

        // If the file does not exist, create it
        if (!file.exists()) {
            file.createNewFile();
        }

        // Write (append) text to the file
        FileWriter writer = new FileWriter(file, true); // 'true' means append mode
        writer.write(text + System.lineSeparator());
        writer.close();
    }

    // Read all content from the file and return it
    public String readFromFile() throws IOException {
        File file = new File(fileName);

        // If file does not exist, return null
        if (!file.exists()) {
            return null;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append(System.lineSeparator());
        }

        reader.close();
        return content.toString();
    }

    // Delete the file if it exists
    public boolean deleteFile() {
        File file = new File(fileName);

        // If file exists, delete it and return the result
        if (file.exists()) {
            return file.delete();
        }

        return false; // File did not exist
    }
}

