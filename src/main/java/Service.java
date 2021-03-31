import java.util.List;

public class Service {

    private ReaderClass readerClass = new ReaderClass();
    private Data data = new Data();


    public void createUser(){

        User user = readerClass.readCreateUser();
        data.addUser(user);

    }

    public void removeUser(User user){

        data.removeUser(user);

    }


    public void createRestaurant(){

        Restaurant restaurant = readerClass.readCreateRestaurant();
        data.addRestaurant(restaurant);

    }

    public void createDeliveryman(){

        Deliveryman deliveryman = readerClass.readCreateDeliveryman();
        data.addDeliverymen(deliveryman);

    }

    public void listRestaurants(){

        List<Restaurant> restaurants = data.getRestaurants();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.toString());
        }

    }

    public void listUsers(){
        List<User> users = data.getUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }

    }

    public void updateProfile(User user){

        System.out.println(user.toString());
        User userNew = readerClass.readCreateUser();
        data.removeUser(user);
        data.addUser(userNew);

    }

    public void listDeliverymen(){

        List<Deliveryman> deliverymen = data.getDeliverymen();
        for (Deliveryman deliveryman : deliverymen) {
            System.out.println(deliveryman.toString());
        }

    }

    public void listCommandHistory(User user){

        List<Command> commands = user.getCommandsHistory();
        for (Command command : commands) {
            System.out.println(command.toString());
        }

    }


}
