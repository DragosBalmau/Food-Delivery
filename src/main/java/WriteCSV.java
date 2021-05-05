import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteCSV {

    private static WriteCSV single_instance = null;

    public <T extends WritableCSV> void write(T object, String path) {
        try (PrintWriter writer = new PrintWriter(new File(path))) {

            writer.write(object.dataCSV());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static WriteCSV getInstance()
    {
        if (single_instance == null)
            single_instance = new WriteCSV();

        return single_instance;
    }
}
