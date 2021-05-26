import Models.*;
import Repositories.*;

import java.io.IOException;
import java.util.List;


public class Service {

    ReaderClass readerClass = new ReaderClass();
    public static Data data = new Data();
    ReadCSV readCSV = ReadCSV.getInstance();
    WriteCSV writeCSV = WriteCSV.getInstance();
    LogWriter log = new LogWriter();
    UserRepository userRepository = new UserRepository();
    RestaurantRepository restaurantRepository = new RestaurantRepository();
    DeliverymanRepository deliverymanRepository = new DeliverymanRepository();
    CommandsRepository commandsRepository = new CommandsRepository();

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

    /*------------------------------DATABASE FUNCTIONS------------------------------*/

    public void insertUsersInDB(){

        userRepository.insertUsers();
        log.writeLog("insertUsers");

    }

    public void updateUserInDB(){

        userRepository.updateUserFirstNameById("testname", 5);
        log.writeLog("updateUser");

    }

    public void deleteUserInDB(){

        userRepository.deleteUserById(3);
        log.writeLog("deleteUser");

    }


    public void insertRestaurantsInDB(){

        restaurantRepository.insertRestaurants();
        log.writeLog("insertRestaurants");

    }

    public void updateRestaurantInDB(){

        restaurantRepository.updateRestaurantTelephoneNumberById("0787878784", "Presto");
        log.writeLog("updateRestaurant");

    }

    public void deleteRestaurantInDB(){

        restaurantRepository.deleteRestaurantByName("KFC");
        log.writeLog("deleteRestaurant");

    }

    public void insertDeliveymenInDB(){

        deliverymanRepository.insertDeliverymen();
        log.writeLog("insertDeliveymen");

    }

    public void updateDeliverymanInDB(){

        deliverymanRepository.updateDeliverymanFirstNameById("testname", 4);
        log.writeLog("updateDeliveryman");

    }

    public void deleteDeliverymanInDB(){

        deliverymanRepository.deleteDeliverymanById(4);
        log.writeLog("deleteDeliveryman");

    }


    public void insertCommandsInDB(){

        commandsRepository.insertCommands();
        log.writeLog("insertCommands");

    }

    public void updateCommandsInDB(){

        commandsRepository.updateCommandsProdusctsById("bananne, mere", 4);
        log.writeLog("updateCommands");

    }

    public void deleteCommandsInDB(){

        commandsRepository.deleteCommandById(4);
        log.writeLog("deleteCommands");

    }

}
