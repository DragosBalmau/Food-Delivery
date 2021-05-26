import java.io.*;
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
        try {
            FileWriter fw = new FileWriter(Constants.CONSTANTS_CSV_PATH, true);
            BufferedWriter csv = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            sb.append(nameMethod).append(",").append(timeStamp).append('\n');
            System.out.println(sb);
            csv.write(sb.toString());
            csv.close();
            fw.close();
        }
            catch (IOException e) {
            e.printStackTrace();
        }
    }

}
