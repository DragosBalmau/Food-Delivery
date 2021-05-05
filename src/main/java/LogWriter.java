import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {

    public void clearLog(){
        try (PrintWriter writer = new PrintWriter(new File(Constants.CONSTANTS_CSV_PATH))) {
            writer.print("");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeLog(String nameMethod){
        try (PrintWriter writer = new PrintWriter(new File(Constants.CONSTANTS_CSV_PATH))) {
            StringBuilder sb = new StringBuilder();
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            sb.append(nameMethod + "," + timeStamp.toString() + '\n');
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
