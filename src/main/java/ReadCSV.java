import java.io.*;

public class ReadCSV {

    private static ReadCSV single_instance = null;

    public <T> void read(Class<T> classType) throws IOException {
        BufferedReader csvReader = null;

        try {
            String path = "";
            if (User.class.equals(classType))
                path = Constants.USERS_CSV_PATH;
            if (Deliveryman.class.equals(classType))
                path = Constants.DELIVERYMEN_CSV_PATH;
            if (Restaurant.class.equals(classType))
                path = Constants.RESTAURANTS_CSV_PATH;
            if (Command.class.equals(classType))
                path = Constants.COMMANDS_CSV_PATH;

            csvReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String row = csvReader.readLine();
        while (csvReader.ready()) {
            String[] dataFromRow = row.split(",");
            if (User.class.equals(classType)) {
                User user = new User(dataFromRow[0], dataFromRow[1], dataFromRow[2], dataFromRow[3], dataFromRow[4], dataFromRow[5], dataFromRow[6], Double.parseDouble(dataFromRow[7]));
                Service.data.addUser(user);
            }
            if (Deliveryman.class.equals(classType)) {
                Deliveryman deliveryman = new Deliveryman(dataFromRow[0], dataFromRow[1], dataFromRow[2], dataFromRow[3], dataFromRow[4], dataFromRow[5], dataFromRow[6], Double.parseDouble(dataFromRow[7]), dataFromRow[8], Integer.parseInt(dataFromRow[9]));
                Service.data.addDeliverymen(deliveryman);
            }
            if (Restaurant.class.equals(classType)) {
                Restaurant restaurant = new Restaurant(dataFromRow[0], dataFromRow[1], dataFromRow[2]);
                Service.data.addRestaurant(restaurant);
            }
            if (Command.class.equals(classType)) {
                Command command = new Command(dataFromRow[0], dataFromRow[1], dataFromRow[2]);
                Service.data.addCommand(command);
            }
            row = csvReader.readLine();
        }
        csvReader.close();
    }

    public static ReadCSV getInstance()
    {
        if (single_instance == null)
            single_instance = new ReadCSV();

        return single_instance;
    }
}
