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
    }

    public void writeToFile(String content) throws IOException {
        fileWriter.write(content);
    }

    public void closeFile() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
