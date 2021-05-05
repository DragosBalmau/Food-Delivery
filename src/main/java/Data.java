import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<User> users = new ArrayList();
    private List<Restaurant> restaurants = new ArrayList();
    private List<Deliveryman> deliverymen = new ArrayList();
    private List<Command> commands = new ArrayList();

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public List<Deliveryman> getDeliverymen() {
        return deliverymen;
    }

    public void setDeliverymen(List<Deliveryman> deliverymen) {
        this.deliverymen = deliverymen;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public void addDeliverymen(Deliveryman deliveryman) {
        this.deliverymen.add(deliveryman);
    }


}
