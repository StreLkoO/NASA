import java.io.*;

public class FileWriter {
    private static FileWriter instance;

    private FileWriter() {
    }

    public static FileWriter get() {
        if (instance == null) {
            instance = new FileWriter();
        }
        return instance;
    }

    public void writeFile(String path, byte[] in) {
        try (FileOutputStream file = new FileOutputStream(path)) {
            file.write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
