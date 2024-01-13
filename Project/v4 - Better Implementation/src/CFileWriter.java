import java.io.FileWriter;
import java.io.IOException;

public class CFileWriter {
    private FileWriter fileWriter;
    private static CFileWriter instance;

    private CFileWriter() {}

    public static CFileWriter getInstance() {
        if (instance == null) {
            instance = new CFileWriter();
        }
        return instance;
    }

    public void openFile(String filePath) throws IOException {
        fileWriter = new FileWriter(filePath);
        System.out.println("\nOpening file"+filePath);
    }

    public void writeToFile(String content) throws IOException {
        fileWriter.write(content);
        System.out.println("Writing to file: "+content);
    }

    public void closeFile() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
            System.out.println("Closing file");
        }
    }
}
