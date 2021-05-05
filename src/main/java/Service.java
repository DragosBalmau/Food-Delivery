import java.io.IOException;
import java.util.List;


public class Service {

    ReaderClass readerClass = new ReaderClass();
    public static Data data = new Data();
    ReadCSV readCSV = ReadCSV.getInstance();
    WriteCSV writeCSV = WriteCSV.getInstance();
    LogWriter log = new LogWriter();

    public void clearLogFile(){
        log.clearLog();
    }

    public void createUser(){

        User user = readerClass.readCreateUser();
        data.addUser(user);
        writeCSV.write(user, Constants.USERS_CSV_PATH);
        log.writeLog("createUser");

    }

    public void removeUser(User user){

        data.removeUser(user);
        log.writeLog("removeUser");

    }

    public void createRestaurant(){

        Restaurant restaurant = readerClass.readCreateRestaurant();
        data.addRestaurant(restaurant);
        writeCSV.write(restaurant, Constants.RESTAURANTS_CSV_PATH);
        log.writeLog("createRestaurant");

    }

    public void createDeliveryman(){

        Deliveryman deliveryman = readerClass.readCreateDeliveryman();
        data.addDeliverymen(deliveryman);
        writeCSV.write(deliveryman, Constants.DELIVERYMEN_CSV_PATH);
        log.writeLog("createDeliveryman");


    }

    public void listRestaurants(){

        List<Restaurant> restaurants = data.getRestaurants();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.toString());
        }
        log.writeLog("listRestaurants");

    }

    public void listCommands(){

        List<Command> commands = data.getCommands();
        for (Command command : commands) {
            System.out.println(command.toString());
        }
        log.writeLog("listCommands");

    }

    public void listUsers(){
        List<User> users = data.getUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        log.writeLog("listUsers");

    }

    public void updateProfile(User user){

        System.out.println(user.toString());
        User userNew = readerClass.readCreateUser();
        data.removeUser(user);
        data.addUser(userNew);
        log.writeLog("updateProfile");

    }

    public void listDeliverymen(){

        List<Deliveryman> deliverymen = data.getDeliverymen();
        for (Deliveryman deliveryman : deliverymen) {
            System.out.println(deliveryman.toString());
        }
        log.writeLog("listDeliverymen");

    }

    public void listCommandHistory(User user){

        List<Command> commands = user.getCommandsHistory();
        for (Command command : commands) {
            System.out.println(command.toString());
        }
        log.writeLog("listCommandHistory");

    }

    public void loadData() throws IOException {

        readCSV.read(User.class);
        readCSV.read(Deliveryman.class);
        readCSV.read(Restaurant.class);
        readCSV.read(Command.class);
        log.writeLog("loadData");

    }

}
