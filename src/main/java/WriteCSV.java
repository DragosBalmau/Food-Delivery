import Models.WritableCSV;

import java.io.*;

public class WriteCSV {

    private static WriteCSV single_instance = null;

    public <T extends WritableCSV> void write(T object, String path) {
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter csv = new BufferedWriter(fw);
            csv.write(object.dataCSV());
            csv.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static WriteCSV getInstance()
    {
        if (single_instance == null)
            single_instance = new WriteCSV();

        return single_instance;
    }
}
